package com.wyh.p2p.controller.admin;

import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;



@Controller("indexAdminController")
public class IndexAdminController {

	@Resource
	private AdminService adminService;

	@RequestMapping("/loginAdmin")
	public String login(Admin admin, HttpSession session) throws Exception {
		String errorInfo = "";
		String statue = "1";
		Admin currnetUser = adminService.getAdminByName(admin.getName());
		if (currnetUser == null) {
			errorInfo = "此用户不存在";
		} else if (admin.getPwd().equals(currnetUser.getPwd())) {
			statue = currnetUser.getStatue();
			session.setAttribute("statue", statue);
			session.setAttribute("currnetUser", currnetUser);
			return "redirect:/admin/main.jsp";
		} else {
			errorInfo = "用户名和密码不匹配";
		}
		session.setAttribute("errorInfo", errorInfo);
		return "redirect:/loginAdmin.jsp";
	}
}
