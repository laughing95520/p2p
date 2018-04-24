package com.wyh.p2p.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.entities.pojo.RepaymentPojo;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pRepayment;
import com.wyh.p2p.generator.entities.TCustomer;
import com.wyh.p2p.service.ApplyLoanService;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.service.RepaymentService;
import com.wyh.p2p.util.CalUtil;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 贷款项目
 *
 * @author wangyiahng
 */
@Controller
@RequestMapping("/admin/repayment")
public class RepaymentAdminController {

    private static boolean flag;

    private static JSONObject result = new JSONObject();

    @Autowired
    private RepaymentService repaymentService;

    @Autowired
    private ApplyLoanService applyLoanService;

    @Autowired
    private CustomerService customerService;

    /**
     * 管理员分页获取还款信息列表
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
                       HttpServletResponse response) throws Exception {
        List<RepaymentPojo> resultList = new ArrayList<>(10);
        List<P2pRepayment> pRepayments = repaymentService.list(Integer.parseInt(page), Integer.parseInt(rows));
        if (pRepayments.size() > 0) {
            PageInfo<P2pRepayment> pageInfo = new PageInfo<>(pRepayments);
            for (P2pRepayment temp : pRepayments) {
                RepaymentPojo pojo = new RepaymentPojo();
                P2pLoan p2pLoan = applyLoanService.findId(temp.getLoanId());
                Customer customer = customerService.getCustomerById(temp.getUid());
                if (p2pLoan !=null && customer !=null) {
                    pojo.setId(temp.getId());
                    pojo.setUid(temp.getUid());
                    pojo.setLoanId(temp.getLoanId());
                    pojo.setCustomerName(customer.getName());
                    pojo.setLendTime(p2pLoan.getLendingTime());
                    pojo.setLoanMoney(p2pLoan.getMoney());
                    pojo.setLoanMonth(p2pLoan.getLoanMonth());
                    pojo.setPayMoney(temp.getPayMoney());
                    pojo.setRepayPeriods(temp.getRepayPeriods());
                    pojo.setRate(p2pLoan.getRate());
                    //还款方式不同，计算还款金额
                    byte repayWay = p2pLoan.getRepayWay();
                    pojo.setPayMethod(repayWay);
                    pojo.setResidueMoney(temp.getResidueMoney());
                    double repayMoneyNow;
                    double residuMoney;
                    if (repayWay == 1){
                        RepaymentPojo tempPojo = CalUtil.calRepayNow(temp.getPayMoney(),p2pLoan.getMoney(),p2pLoan.getLoanMonth(),temp.getRepayPeriods());
                        pojo.setRepayMoneyNow(tempPojo.getRepayMoneyNow());
                        //pojo.setResidueMoney(tempPojo.getResidueMoney());
                    }else if (repayWay == 2){
                        if (temp.getRepayPeriods() == 0){
                            repayMoneyNow = p2pLoan.getMoney()+p2pLoan.getInterest();
                            residuMoney = p2pLoan.getMoney()+p2pLoan.getInterest();
                        }else{
                            repayMoneyNow = 0;
                            residuMoney = 0;
                        }
                        pojo.setRepayMoneyNow(repayMoneyNow);
                        //pojo.setResidueMoney(residuMoney);
                    }
                }
                resultList.add(pojo);
            }
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
            JSONArray jsonArray = JSONArray.fromObject(resultList, jsonConfig);
            result.put("rows", jsonArray);
            result.put("pages", pageInfo.getPages());
            result.put("total", pageInfo.getTotal());
        }
        ResponseUtil.write(response, result);
        return null;
    }


    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("id")String id,@RequestParam("message")String message,
                              HttpServletResponse response) throws IOException {
        int uid = Integer.parseInt(id);
        TCustomer customer = new TCustomer();
        customer.setMessage(message);
        customer.setFid(uid);
        flag = customerService.updateById(customer);
        result.put("success",flag);
        ResponseUtil.write(response,result);
        return null;
    }

	/*@RequestMapping("/save")
	public String save(HttpServletResponse response, P2pRate p2pRate) throws Exception {
		float rate = p2pRate.getRate();
		BigDecimal b = new BigDecimal(rate);
		rate = b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
		p2pRate.setRate(rate);
		flag = loanRateService.save(p2pRate);
		result.put("success", flag);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/del")
	public String del(HttpServletResponse response, @RequestParam("ids") String ids) throws Exception {
		String[] id = ids.split(",");
		List<Integer> idlist = new ArrayList<>(10);
		for (String fid : id) {
			idlist.add(Integer.parseInt(fid));
		}
		flag = loanRateService.del(idlist);
		result.put("success", flag);
		ResponseUtil.write(response, result);
		return null;
	}*/

}
