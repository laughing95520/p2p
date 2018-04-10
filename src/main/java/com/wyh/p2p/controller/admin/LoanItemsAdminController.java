package com.wyh.p2p.controller.admin;

import com.wyh.p2p.entities.LoanItems;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.service.LoanItemsService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 贷款项目
 * 
 * 
 */
@Controller
@RequestMapping("/admin/loanItems")
public class LoanItemsAdminController {

	@Resource
	private LoanItemsService loanItemsService;

	@RequestMapping("/list")
	public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<LoanItems> loanItemsList = loanItemsService.list(map);
		Long total = loanItemsService.getTotal();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(loanItemsList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/save")
	public String save(HttpServletResponse response, LoanItems loanItems) throws Exception {
		loanItemsService.save(loanItems);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/del")
	public String del(HttpServletResponse response, @RequestParam("ids") String ids) throws Exception {
		String[] id = ids.split(",");
		for (String fid : id) {
			loanItemsService.del(Integer.parseInt(fid));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/release")
	public String release(HttpServletResponse response, @RequestParam("ids") String ids,
			@RequestParam("release") String release) throws Exception {
		String[] id = ids.split(",");
		int releaseTemp = Integer.parseInt(release);
		Map<String, Object> map = new HashMap<String, Object>();
		for (String fid : id) {
			map.put("releaseTemp", releaseTemp);
			map.put("fid", fid);
			loanItemsService.release(map);
			map.clear();
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
