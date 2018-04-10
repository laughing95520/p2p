package com.wyh.p2p.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.service.AdminService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private AdminService adminService;

	/**
	 * 用户退出
	 *
	 * @return
	 */
	@RequestMapping("/logout")
	public String loginOut(HttpSession session) {
		// 从sesion移出当前登录的用户
		session.removeAttribute("currnetUser");
		return "redirect:/loginAdmin.jsp";
	}

	@RequestMapping("/list")
	public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Admin> adminList = adminService.list(map);
		Long total = adminService.getTotle();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(adminList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/modifyPwd")
	public String modifyPassword(String newPassword, HttpSession session, HttpServletResponse response)
			throws Exception {
		Admin admin = (Admin) session.getAttribute("currnetUser");
		admin.setPwd(newPassword);
		adminService.update(admin);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/save")
	public String save(Admin admin, HttpServletResponse response) throws Exception {
		if (admin.getId() != 0) {
			adminService.update(admin);
		} else {
			adminService.add(admin);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/delete")
	public String del(HttpServletResponse response, @RequestParam("ids") String ids) throws Exception {
		String[] id = ids.split(",");
		for (String fid : id) {
			adminService.del(Integer.parseInt(fid));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
