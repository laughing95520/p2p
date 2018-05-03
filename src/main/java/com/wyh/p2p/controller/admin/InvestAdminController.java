package com.wyh.p2p.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wyh.p2p.entities.pojo.InvestPojo;
import com.wyh.p2p.generator.entities.P2pInvest;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.service.InvestService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wangyihang
 * @date 2018/5/2 下午5:17
 **/
@Controller
@RequestMapping("/admin/invest")
public class InvestAdminController {

    private static Logger logger = Logger.getLogger(InvestAdminController.class);

    @Autowired
    private InvestService investService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
            HttpServletResponse response) {
        try {
            List<InvestPojo> investPojos = investService.pageList(Integer.parseInt(page), Integer.parseInt(rows));
            for (InvestPojo tempPojo:investPojos) {
                String userName = customerService.getCustomerById(tempPojo.getUid()).getName();
                tempPojo.setUserName(userName);
            }
            PageInfo<InvestPojo> p = new PageInfo<>(investPojos);
            JSONObject res = new JSONObject();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
            JSONArray jsonArray = JSONArray.fromObject(investPojos, jsonConfig);
            res.put("rows", jsonArray);
            res.put("total", p.getTotal());
            res.put("pages", p.getPages());
            ResponseUtil.write(response, res);
        } catch (Exception e) {
            logger.error("list投资产品 error" + e);
        }
        return null;
    }

    @RequestMapping("/returnMoneyToUser")
    @Transactional(rollbackFor = Exception.class)
    public void returnMoneyToUser(@RequestParam("id")String id,HttpServletResponse response) throws IOException {
        boolean flag;
        JSONObject result = new JSONObject();
        try{
            int iid = Integer.parseInt(id);
            P2pInvest p2pInvest = investService.getByIid(iid);
            double allMoney = p2pInvest.getMoney()+p2pInvest.getIncome();
            allMoney = new BigDecimal(allMoney).setScale(2).doubleValue();
            double income = new BigDecimal(p2pInvest.getIncome()).setScale(2).doubleValue();
            flag = customerService.addInvestMoney(allMoney,income,p2pInvest.getUid());
            if (flag){
                flag = investService.changeState(iid);
            }
            result.put("success",flag);
        }catch (Exception e){
            logger.error("归还用户投资本金和收益失败！error:"+e);
        }finally {
            ResponseUtil.write(response,result);
        }
    }
}

