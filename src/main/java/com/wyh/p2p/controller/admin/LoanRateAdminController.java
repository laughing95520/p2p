package com.wyh.p2p.controller.admin;

import com.wyh.p2p.generator.entities.P2pRate;
import com.wyh.p2p.service.LoanRateService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 贷款项目
 * @author wangyiahng
 */
@Controller
@RequestMapping("/admin/loanRate")
public class LoanRateAdminController {

	private static boolean flag;

	private static JSONObject result = new JSONObject();

	@Autowired
	private LoanRateService loanRateService;

	@RequestMapping("/list")
	public String list(HttpServletResponse response) throws Exception {
		List<P2pRate> pRateList = loanRateService.list();
		result.put("rows", pRateList);
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/save")
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
	}

}
