package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Credit;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.entities.CustomerDetail;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.service.*;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户Controller
 * 
 * @author
 * 
 */
@Controller
@RequestMapping("/user/customer")
public class CustomerController {

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@Resource
	private CustomerService customerService;

	@Resource
	private CustomerDetailService customerDetailService;

	@Resource
	private CreditService creditService;

	@Resource
	private ApplicationService applicationService;

	@Autowired
	private ApplyLoanService applyLoanService;

	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customerUser");
		int cusId = customer.getId();
		List<P2pLoan> p2pLoanList = applyLoanService.findByCusId(cusId);
		Map<String, Object> loanInfoMap = new HashMap<String, Object>(10);
		loanInfoMap.put("loanNum",p2pLoanList.size());
		double allMoney  = 0;
		int successNum = 0;
		if (p2pLoanList.size() > 0) {
			for (P2pLoan list : p2pLoanList
					) {
				allMoney += list.getMoney();
				if (list.getState() == 2) {
					successNum += 1;
				}
			}
		}
		CustomerDetail customerDetail = customerDetailService.getInfo(cusId);
		String photo = "";
		if (customerDetail != null) {
			photo = customerDetail.getPhoto();
		}
		loanInfoMap.put("allMoney",allMoney);
		loanInfoMap.put("successNum",successNum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainTempIndex", 2);
		mv.addObject("mainPersonIndex", 1);
		mv.addObject("loanInfoMap", loanInfoMap);
		mv.addObject("customer", customer);
		mv.addObject("photo",photo);
		mv.setViewName("usermain/usermain");
		return mv;
//		Customer customer = (Customer) session.getAttribute("customerUser");
//		customer = customerService.getCustomerById(customer.getId());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", customer.getId());
//		map.put("success", 0);
//		int loanNum = applicationService.loanNum(map);
//		personInfoMap.put("loanNum", loanNum);
//		map.put("success", 1);
//		int successLoanNum = applicationService.loanNum(map);
//		personInfoMap.put("successLoanNum", successLoanNum);
//		int totalMoney = 0;
//		if (successLoanNum > 0) {
//			totalMoney = applicationService.getTotleMoney(customer.getId());
//		}
//		personInfoMap.put("totalMoney", totalMoney);
//		CustomerDetail customerDetail = customerDetailService.getInfo(customer.getId());
//		String photo = "";
//		if (customerDetail != null) {
//			photo = customerDetail.getPhoto();
//		}
//		personInfoMap.put("photo", photo);

	}

	@RequestMapping("/updatephoto")
	public String updatePhoto(HttpServletResponse response, MultipartFile file, HttpServletRequest request,
			HttpSession session) throws Exception {
		String fileName = file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("static/images");
		File targetFile = new File(path, fileName);
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
		}
		String filePath = "static/images/" + file.getOriginalFilename();
		Customer customerTemp = (Customer) session.getAttribute("customerUser");
		CustomerDetail customerDetail = customerDetailService.getInfo(customerTemp.getId());
		if (customerDetail == null) {
			customerDetail = new CustomerDetail();
			customerDetail.setCustomerId(customerTemp.getId());
			customerDetail.setPhoto(filePath);
			customerDetailService.add(customerDetail);
		} else {
			customerDetail.setPhoto(filePath);
			customerDetailService.update(customerDetail);
		}
		JSONObject result = new JSONObject();
		result.put("imagePath", filePath);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/personinfo")
	public ModelAndView personInfo(HttpSession session) {
		Customer customerTemp = (Customer) session.getAttribute("customerUser");
		Customer customer = customerService.getCustomerById(customerTemp.getId());
		CustomerDetail customerDetail = customerDetailService.getInfo(customerTemp.getId());
		if (customerDetail == null) {
			customerDetail = new CustomerDetail();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerDetail", customerDetail);
		mv.addObject("customer", customer);
		mv.addObject("mainTempIndex", 2);
		mv.addObject("mainPersonIndex", 2);
		mv.setViewName("usermain/personalInfo");
		return mv;
	}

	@RequestMapping("/personupdate")
	public ModelAndView personupdate(HttpSession session, Customer customer, CustomerDetail customerDetail) {
		Customer customerUser = (Customer) session.getAttribute("customerUser");
		customer.setId(customerUser.getId());
		customer.setPassword(customerUser.getPassword());
		customerService.update(customer);
		customerDetail.setCustomerId(customerUser.getId());
		CustomerDetail customerDetail2 = customerDetailService.getInfo(customerUser.getId());
		if (customerDetail2 == null) {
			customerDetailService.add(customerDetail);
		} else {
			customerDetail.setPhoto(customerDetail2.getPhoto());
			customerDetailService.update(customerDetail);
		}
		return new ModelAndView("redirect:/user/customer/personinfo.html");
	}

	@RequestMapping("/personpwd")
	public ModelAndView personPwd(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainTempIndex", 2);
		mv.addObject("mainPersonIndex", 3);
		mv.setViewName("usermain/setpassword");
		return mv;
	}

	@RequestMapping("/personsetpwd")
	public String personSetPwd(HttpSession session, HttpServletResponse response, String pwd, String newpwd,
			String newpwd2) throws Exception {

		JSONObject result = new JSONObject();
		String info = "密码修改成功";
		Customer customerTemp = (Customer) session.getAttribute("customerUser");
		customerTemp.setPassword(pwd);
		Customer customer = customerService.login(customerTemp);
		if (customer == null) {
			info = "初始密码不正确";
		} else if (!newpwd.equals(newpwd2)) {
			info = "两次密码不一致";
		} else {
			customer.setPassword(newpwd);
			customerService.update(customer);
		}
		result.put("success", true);
		result.put("info", info);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/personcredit")
	public ModelAndView personCredit(HttpSession session) {
		String credit = "";
		Customer customerTemp = (Customer) session.getAttribute("customerUser");
		Credit creditTemp = creditService.getByCustomerId(customerTemp.getId());
		if (creditTemp.getCredit() == 0) {
			credit = "优秀";
		} else if (creditTemp.getCredit() == 1) {
			credit = "良好";
		} else {
			credit = "不良";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("credit", credit);
		mv.addObject("mainTempIndex", 2);
		mv.addObject("mainPersonIndex", 4);
		mv.setViewName("usermain/creditProfile");
		return mv;
	}

	/**
	 * 用户退出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginout")
	public String loginOut(HttpSession session) {
		// 获取当前登录的用户
		session.removeAttribute("customerUser");
		return "redirect:/index.html";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
