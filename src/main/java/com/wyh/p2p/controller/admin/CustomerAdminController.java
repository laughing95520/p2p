package com.wyh.p2p.controller.admin;

import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.entities.PageBean;
import com.wyh.p2p.service.CustomerService;
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

@Controller
@RequestMapping("/admin/customer")
public class CustomerAdminController {

	@Resource
	private CustomerService customerService;

	@RequestMapping("/list")
	public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Customer> customerList = customerService.list(map);
		Long total = customerService.getTotle();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(customerList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/changeBalance")
	public void listBalance(@RequestParam("type")String type,@RequestParam("id")String id,
									@RequestParam("payMoney")String money,
							HttpServletResponse response)throws Exception{
		JSONObject result = new JSONObject();
		//todo:操作账户余额
		try {
			int typeInt = Integer.parseInt(type);
			int cusId = Integer.parseInt(id);
			double payMoney = Double.parseDouble(money);
			boolean flag = false;
			if (typeInt == 1) {
				//add
				flag = customerService.addBalance(payMoney,cusId);
			} else if (typeInt == 2) {
				//reduce
				Customer customer = customerService.getCustomerById(cusId);
				if (customer!=null) {
					if (customer.getBalance() >= payMoney){
						flag = customerService.redBalance(payMoney,cusId);
					}
				}
			}
			result.put("success",flag);
		}catch (Exception e){
			result.put("success",false);
		}
		ResponseUtil.write(response, result);
	}


	@RequestMapping("/del")
	public String del(HttpServletResponse response, @RequestParam("ids") String ids) throws Exception {
		String[] id = ids.split(",");
		for (String fid : id) {
			customerService.del(Integer.parseInt(fid));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
