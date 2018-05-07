package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Credit;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.generator.entities.P2pMessage;
import com.wyh.p2p.generator.entities.P2pProduct;
import com.wyh.p2p.service.CreditService;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.service.ProductService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

	@Resource
	private CustomerService customerService;

	@Resource
	private CreditService creditService;

	@Autowired
    private ProductService productService;

	@Autowired
	private TaskService taskService;

	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		List<P2pProduct> products = productService.viewList(0);
		Customer customer = (Customer) session.getAttribute("customerUser");
		if (customer != null) {
			List<P2pMessage> userMessage = customerService.getMessageByUid(customer.getId());
			if (userMessage.size() > 0){
				mv.addObject("messageNUm",userMessage.size());
			}
		}
		session.setAttribute("productList", products);
		mv.addObject("mainTempIndex", 1);
		mv.setViewName("mainTemp");
		return mv;
	}

	@RequestMapping("/login")
	public String login(Customer customerUser, HttpSession session) throws Exception {
		// 获取当前登录的用户
		Customer customerTemp = customerService.login(customerUser);
		if (customerTemp != null) {
			session.setAttribute("customerUser", customerTemp);
		} else {
			session.setAttribute("error", "账户或密码错误！");
			return "redirect:/index.html";
		}
		return "redirect:/index.html";
	}

	@RequestMapping("/existName")
	public String findBloggerByName(@RequestParam("userName") String userName,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		Long val = customerService.getCustomerByName(userName);
		if (val == 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/register")
	public String add(Customer customer, HttpServletResponse response) throws Exception {
		customerService.add(customer);
		Credit credit = new Credit();
		credit.setUserId(customer.getId());
		credit.setCredit(1);
		creditService.add(credit);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
