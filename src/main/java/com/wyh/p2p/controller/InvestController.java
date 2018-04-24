package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.generator.entities.P2pInvest;
import com.wyh.p2p.generator.entities.P2pProduct;
import com.wyh.p2p.service.InvestService;
import com.wyh.p2p.service.ProductService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author wangyihang
 */
@Controller
@RequestMapping("/user/invest")
public class InvestController {

    private static Logger logger = Logger.getLogger(InvestController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private InvestService investService;

    @RequestMapping("/investCal")
    public ModelAndView invest(HttpSession session, @RequestParam("id") String id) {
        int pid = Integer.parseInt(id);
        P2pProduct product = productService.getProById(pid);
        session.setAttribute("product", product);
        ModelAndView mv = new ModelAndView();
        mv.addObject("mainTempIndex", 1);
        mv.setViewName("invest/investCalculate");
        return mv;
    }

    @RequestMapping("/investRecord")
    @Transactional(rollbackFor = Exception.class)
    public void investRecord(HttpSession session, HttpServletResponse response,
                             @RequestParam("invmon")String invMon,
                             @RequestParam("pid")String pid,
                             @RequestParam("period")String period) throws IOException {
        JSONObject result = new JSONObject();
        P2pInvest p2pInvest = new P2pInvest();
        boolean flag = false;
        try {
            double investMoney = Double.parseDouble(invMon);
            P2pProduct p2pProduct = productService.getProById(Integer.parseInt(pid));
            float rate = p2pProduct.getRate();
            int pIntId = Integer.parseInt(pid);
            int timeLine = Integer.parseInt(period);
            double investEar = investMoney*(rate/100/12)*timeLine;
            BigDecimal b  =  new  BigDecimal(investEar);
            investEar  =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            Customer customer = (Customer) session.getAttribute("customerUser");
            int uid = customer.getId();
            p2pInvest.setPid(pIntId);
            p2pInvest.setUid(uid);
            p2pInvest.setIncome(investEar);
            p2pInvest.setMoney(investMoney);
            p2pInvest.setTimeLine(timeLine);
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime endLocal = localDateTime.plusMonths(timeLine);
            p2pInvest.setStartDate(changToDate(localDateTime));
            p2pInvest.setEndDate(changToDate(endLocal));
            flag = investService.addInvest(p2pInvest);
            if (flag) {
                flag = productService.update(p2pProduct.getId(), investMoney);
            }
        }catch (Exception e){
            logger.error("用户投资出错！投资产品pid:"+pid+e);
        }finally {
            result.put("success",flag);
            ResponseUtil.write(response, result);
        }
    }

    private Date changToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date stadate = Date.from(instant);
        return stadate;
    }

}
