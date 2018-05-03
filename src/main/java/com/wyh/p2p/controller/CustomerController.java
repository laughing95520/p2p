package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Credit;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.entities.CustomerDetail;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pMessage;
import com.wyh.p2p.service.*;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

	@RequestMapping("/changeState")
	public String changeState(@RequestParam("ids")String ids, HttpSession session,HttpServletResponse response) throws IOException {
		Customer customer = (Customer) session.getAttribute("customerUser");
		int uid = customer.getId();
		boolean flag;
		JSONObject result = new JSONObject();
		String[] id = ids.split(",");
		List<Integer> idlist = new ArrayList<>(10);
		for (String fid : id) {
			idlist.add(Integer.parseInt(fid));
		}
		flag =customerService.changeMessageState(idlist,uid);
		result.put("success",flag);
		ResponseUtil.write(response,result);
		return null;
	}


	@RequestMapping("/messageList")
	public String messageList(HttpSession session,HttpServletResponse response) throws IOException {
		JSONObject result = new JSONObject();
		Customer customer = (Customer) session.getAttribute("customerUser");
		if (customer!=null){
			List<P2pMessage> messList = customerService.getMessageByUid(customer.getId());
			if (messList.size()>0){
				result.put("success",true);
				result.put("messages",messList);
			}
		}else{
			result.put("success",false);
		}
		ResponseUtil.write(response,result);
		return null;
	}


	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customerUser");
		customer = customerService.getCustomerById(customer.getId());
		session.setAttribute("customerUser",customer);
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
	public ModelAndView personupdate(HttpSession session, Customer customer, CustomerDetail customerDetail, @RequestParam("birthday")String birth) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate;
		birthDate = dateFormat.parse(birth);
		customer.setBirthday(birthDate);
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
