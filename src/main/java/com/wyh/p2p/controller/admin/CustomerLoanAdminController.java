package com.wyh.p2p.controller.admin;

import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.entities.CustomerLoan;
import com.wyh.p2p.entities.CustomerLoanSon;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.service.CustomerLoanService;
import com.wyh.p2p.service.CustomerLoanSonService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/customerloan")
public class CustomerLoanAdminController {

	@Resource
	private CustomerLoanService customerLoanService;

	@Resource
	private CustomerLoanSonService customerLoanSonService;

	@RequestMapping("/list")
	public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<CustomerLoan> customerLoanList = customerLoanService.list(map);
		Long total = customerLoanService.getTotle();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(customerLoanList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/loaninfoson")
	public String loanInfoSon(HttpSession session, HttpServletResponse response, String id) throws Exception {
		CustomerLoan customerLoanInfo = customerLoanService.getById(id);
		List<CustomerLoanSon> loanIncome = null;
		List<CustomerLoanSon> loanRoom = null;
		List<CustomerLoanSon> loanJob = null;
		List<CustomerLoanSon> loanCredit = null;
		List<CustomerLoanSon> loanSalary = null;
		if (customerLoanInfo != null) {
			loanIncome = customerLoanSonService.getFileType(1, customerLoanInfo.getId());
			loanRoom = customerLoanSonService.getFileType(2, customerLoanInfo.getId());
			loanJob = customerLoanSonService.getFileType(4, customerLoanInfo.getId());
			loanCredit = customerLoanSonService.getFileType(3, customerLoanInfo.getId());
			loanSalary = customerLoanSonService.getFileType(5, customerLoanInfo.getId());
		}
		session.setAttribute("loanIncome", loanIncome);
		session.setAttribute("loanRoom", loanRoom);
		session.setAttribute("loanJob", loanJob);
		session.setAttribute("loanCredit", loanCredit);
		session.setAttribute("loanSalary", loanSalary);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/approval")
	public String save(String reason, String approvalStatue, HttpServletResponse response, String id,
			HttpSession session) throws Exception {
		Admin admin = (Admin) session.getAttribute("currnetUser");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("adminId", admin.getId());
		map.put("approvalStatue", approvalStatue);
		map.put("reason", reason);
		customerLoanService.approval(map);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
