package com.wyh.p2p.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.entities.Application;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.entities.pojo.ApplyLoan;
import com.wyh.p2p.generator.entities.P2pGuarantee;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pRepayment;
import com.wyh.p2p.service.*;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/application")
public class ApplicationAdminController {

	private static Logger logger = Logger.getLogger(ApplicationAdminController.class);

	@Resource
	private ApplicationService applicationService;

	@Autowired
	private ApplyLoanService applyLoanService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GuaranteeService guaranteeService;

	@Autowired
	private RepaymentService repaymentService;

	@RequestMapping("/listLoan")
	public void listLoan(@RequestParam("page") String page, @RequestParam("rows") String rows,
						 HttpServletResponse response){
		try {
			List<P2pLoan> p2pLoanList = applyLoanService.list(Integer.parseInt(page),Integer.parseInt(rows));
			List<ApplyLoan> applyLoans = new ArrayList<ApplyLoan>(20);
			for (P2pLoan temp:p2pLoanList
				 ) {
				ApplyLoan appTemp = converToApplyLoan(temp);
				String name = customerService.getCustomerById(appTemp.getCustomerId()).getName();
				appTemp.setCustomerName(name);
				applyLoans.add(appTemp);
			}
			PageInfo<P2pLoan> p = new PageInfo<P2pLoan>(p2pLoanList);
			JSONObject res = new JSONObject();
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
			JSONArray jsonArray = JSONArray.fromObject(applyLoans, jsonConfig);
			res.put("rows", jsonArray);
			res.put("pages", p.getPages());
			res.put("total", p.getTotal());
			ResponseUtil.write(response, res);
		}catch (Exception e ){
			logger.error("listLoan error"+e);
		}


	}

	private ApplyLoan converToApplyLoan(P2pLoan temp) {
		ApplyLoan applyLoan = new ApplyLoan();
		applyLoan.setId(temp.getId());
		applyLoan.setCustomerId(temp.getCustomerId());
		applyLoan.setGuaranteeId(temp.getGuaranteeId());
		applyLoan.setInterest(temp.getInterest());
		applyLoan.setLoanMonth(temp.getLoanMonth());
		applyLoan.setMoney(temp.getMoney());
		applyLoan.setRate(temp.getRate());
		applyLoan.setRepayWay(temp.getRepayWay());
		applyLoan.setState(temp.getState());
		applyLoan.setLendingTime(temp.getLendingTime());
		applyLoan.setLoanTime(temp.getLoanTime());
		applyLoan.setWords(temp.getWords());
		return applyLoan;
	}

	@RequestMapping("/findGuarantee")
	public void findGuarantee(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		JSONObject result = new JSONObject();
		try {
			int cusId = Integer.parseInt(id);
			P2pGuarantee p2pGuarantee = guaranteeService.findByCusId(cusId);
			if (p2pGuarantee != null) {
				result.put("frontPath",p2pGuarantee.getCardFront());
				result.put("backPath",p2pGuarantee.getCardBack());
				result.put("guaType",p2pGuarantee.getType());
				result.put("guaPath",p2pGuarantee.getPhotoPath());
			}
			ResponseUtil.write(response,result);
		}catch (Exception e){
			logger.error("查看用户贷款担保信息出错"+e);
		}

	}

	@RequestMapping("/list")
	public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
			HttpServletResponse response, HttpSession session) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		Admin admin = (Admin) session.getAttribute("currnetUser");
		map.put("statue", admin.getStatue());
		List<Application> ApplicationList = applicationService.list(map);
		Long total = applicationService.getTotle(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(ApplicationList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/approval")
    @Transactional(rollbackFor = Exception.class)
	public ModelAndView save(String reason, String approvalStatue, HttpServletResponse response, String id,
			HttpSession session) {
		JSONObject result = new JSONObject();
        ModelAndView mv = new ModelAndView();
		try {
			Admin admin = (Admin) session.getAttribute("currnetUser");
			String words = reason + "审核人：" + admin.getName();
			byte state = Byte.parseByte(approvalStatue);
			int loanId = Integer.parseInt(id);
			boolean flag;
			boolean res=false;
			//更改贷款申请状态以及审核
			flag = applyLoanService.changeLoan(loanId, state, words);
			if (flag) {
                P2pLoan applyLoan = applyLoanService.findId(loanId);
                if (applyLoan!=null) {
                    boolean cusFlag;
                    //放贷成功后修改用户余额
                    cusFlag = customerService.addBalance(applyLoan.getMoney(),applyLoan.getCustomerId());
                    if (cusFlag){
                    	//放贷成功，新增还款信息
						double interest = applyLoan.getInterest()+applyLoan.getMoney();
						P2pRepayment p2pRepayment = new P2pRepayment();
						p2pRepayment.setLoanId(loanId);
						p2pRepayment.setUid(applyLoan.getCustomerId());
						p2pRepayment.setLoanMoney(applyLoan.getMoney());
						p2pRepayment.setResidueMoney(interest);
						p2pRepayment.setPayMoney(interest);
						p2pRepayment.setRepayPeriods(0);
                    	res = repaymentService.add(p2pRepayment);
                    }
                }
			}
			result.put("success", res);
			ResponseUtil.write(response, result);
			return null;
		}catch (Exception e){
			logger.error("loan save error:"+e);
			mv.setViewName("error");
			return mv;
		}
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("adminId", admin.getId());
		map.put("statue", admin.getStatue());
		map.put("approvalStatue", approvalStatue);
		map.put("reason", reason);
		applicationService.approval(map);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;*/
	}
}
