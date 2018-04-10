package com.wyh.p2p.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.entities.Application;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.service.ApplicationService;
import com.wyh.p2p.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/admin/application")
public class ApplicationAdminController {

	@Resource
	private ApplicationService applicationService;

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
	public String save(String reason, String approvalStatue, HttpServletResponse response, String id,
			HttpSession session) throws Exception {
		Admin admin = (Admin) session.getAttribute("currnetUser");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("adminId", admin.getId());
		map.put("statue", admin.getStatue());
		map.put("approvalStatue", approvalStatue);
		map.put("reason", reason);
		applicationService.approval(map);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
