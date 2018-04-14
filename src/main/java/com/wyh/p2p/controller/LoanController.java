package com.wyh.p2p.controller;

import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.entities.CustomerLoan;
import com.wyh.p2p.entities.CustomerLoanSon;
import com.wyh.p2p.entities.LoanItems;
import com.wyh.p2p.generator.entities.P2pGuarantee;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.service.*;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @author wangyihang
 */
@Controller
@RequestMapping("/user/loan")
public class LoanController {

    private static Logger logger = Logger.getLogger(LoanController.class);

    @Resource
    private LoanItemsService loanItemsService;

    @Resource
    private ApplicationService applicationService;

    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerDetailService customerDetailService;

    @Resource
    private CustomerLoanService customerLoanService;

    @Resource
    private CustomerLoanSonService customerLoanSonService;

    @Autowired
    private ApplyLoanService applyLoanService;

    @Autowired
    private GuaranteeService guaranteeService;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mainTempIndex", 3);
        mv.setViewName("mainTemp");
        return mv;
    }

    @RequestMapping("/loan")
    public ModelAndView loan(HttpSession session, @RequestParam("id") String id) {
        LoanItems loanItem = loanItemsService.getLoanItemsById(id);
        session.setAttribute("loanItem", loanItem);
        ModelAndView mv = new ModelAndView();
        mv.addObject("mainTempIndex", 1);
        mv.setViewName("loanManage/woyaodaikuan");
        return mv;
    }


    @RequestMapping("/applyLoan")
    public ModelAndView applyLoan() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mainTempIndex", 3);
        mv.setViewName("loanManage/applyLoan");
        return mv;
    }


    @RequestMapping("/applynow")
    public void applyNow(HttpServletResponse response,
                         HttpSession session,
                         @RequestParam("money") String money,
                         @RequestParam("loanMonth") String loanMonth,
                         @RequestParam("rate") String rate,
                         @RequestParam("repayWay") String repayWay,
                         @RequestParam("interest") String interest
    ) {
        JSONObject result = new JSONObject();
        P2pLoan p2pLoan = new P2pLoan();
        try {
            Customer customer = (Customer) session.getAttribute("customerUser");
            int cusId = customer.getId();
            if (customerService.checkInfo(customer) && customerDetailService.checkInfo(customer.getId())) {
                if (guaranteeService.checkInfo(cusId)) {
                    int guaId = guaranteeService.findByCusId(cusId).getId();
                    p2pLoan.setGuaranteeId(guaId);
                    p2pLoan.setMoney(Double.valueOf(money));
                    p2pLoan.setLoanMonth(Integer.valueOf(loanMonth));
                    p2pLoan.setRate(Float.valueOf(rate));
                    p2pLoan.setRepayWay(Byte.valueOf(repayWay));
                    p2pLoan.setInterest(Double.valueOf(interest));
                    p2pLoan.setCustomerId(cusId);
                    p2pLoan.setState((byte) 1);
                    boolean flag;
                    flag = applyLoanService.insertApply(p2pLoan);
                    if (flag) {
                        result.put("success", 0);
                        ResponseUtil.write(response, result);
                    } else {
                        logger.error("数据库操作失败");
                    }
                } else {
                    result.put("success", 1);
                }
            } else {
                result.put("success", 2);
            }
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            logger.error("申请贷款error" + "e:" + e);
        }
    }


    @RequestMapping("/myloan")
    public ModelAndView myLoan(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customerUser");
        int cusId = customer.getId();
        List<P2pLoan> p2pLoanList = applyLoanService.findByCusId(cusId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("loanList", p2pLoanList);
        mv.addObject("mainTempIndex", 3);
        mv.addObject("loanIndex", 1);
        mv.setViewName("loanManage/myloan");
        return mv;
    }

    @RequestMapping("/loaninfo")
    public ModelAndView loanInfo(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        try {
            Customer customerTemp = (Customer) session.getAttribute("customerUser");
            int cusId = customerTemp.getId();
            if (guaranteeService.checkInfo(cusId)) {
                P2pGuarantee p2pGuarantee = guaranteeService.findByCusId(cusId);
                mv.addObject("cardFront", p2pGuarantee.getCardFront());
                mv.addObject("cardBack", p2pGuarantee.getCardBack());
                mv.addObject("type", p2pGuarantee.getType());
                mv.addObject("imgPath", p2pGuarantee.getPhotoPath());
            }
            mv.addObject("mainTempIndex", 3);
            mv.addObject("loanIndex", 2);
            mv.setViewName("loanManage/guarantee");
            return mv;
        } catch (Exception e) {
            logger.error("loanInfo error" + e);
            mv.setViewName("error");
            return mv;
        }
    }

    @RequestMapping("/uploadwyh")
    public ModelAndView uploadWyh(HttpServletResponse response, MultipartFile file, HttpServletRequest request,
                            HttpSession session, @RequestParam("type") String type) {
        P2pGuarantee p2pGuarantee;
        JSONObject result = new JSONObject();
        ModelAndView mv = new ModelAndView();
        try {
            Customer customer = (Customer) session.getAttribute("customerUser");
            int cusId = customer.getId();
            //TODO: 贷款资料时，考虑用户贷款资料表为空的情况。
            p2pGuarantee = guaranteeService.findByCusId(cusId);
            if (p2pGuarantee == null) {
                p2pGuarantee = new P2pGuarantee();
                p2pGuarantee.setCustomerId(0);
            }
            byte typeByte = Byte.valueOf(type);
            String fileName = file.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath("static/images");
            File targetFile = new File(path, fileName);
            file.transferTo(targetFile);
            String filePath = "static/images/" + file.getOriginalFilename();

            switch (typeByte) {
                case 1:
                case 2:
                case 3:
                    p2pGuarantee.setType(typeByte);
                    p2pGuarantee.setPhotoPath(filePath);
                    break;
                case 6:
                    p2pGuarantee.setCardFront(filePath);
                    break;
                case 7:
                    p2pGuarantee.setCardBack(filePath);
                    break;
                default:
                    break;
            }
            boolean flag = false;
            //是否上传过担保资料
            if (p2pGuarantee.getCustomerId() != 0) {
                flag = guaranteeService.updateSelect(p2pGuarantee);
            } else if (p2pGuarantee.getCustomerId() == 0) {
                p2pGuarantee.setCustomerId(cusId);
                flag = guaranteeService.insertSelect(p2pGuarantee);
            }
            if (flag) {
                result.put("imagePath", filePath);
                result.put("type", type);
            } else {
                result.put("error", "error");
            }
            ResponseUtil.write(response, result);
            return null;
        } catch (Exception e) {
            logger.error("图片上传错误" + e);
            mv.setViewName("error");
            return mv;
        }
    }

    @RequestMapping("/upload")
    public String upload(HttpServletResponse response, MultipartFile file, HttpServletRequest request,
                         HttpSession session) throws Exception {
        String type = request.getParameter("type");
        String fid = request.getParameter("fid");
        int statue = Integer.parseInt(type);
        int id = Integer.parseInt(fid);
        String fileName = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("static/images");
        File targetFile = new File(path, fileName);
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
        }
        String filePath = "static/images/" + file.getOriginalFilename();
        Customer customerTemp = (Customer) session.getAttribute("customerUser");
        CustomerLoan customerLoan = customerLoanService.getByCustomerId(customerTemp.getId());
        if (customerLoan != null) {
            switch (statue) {
                case 6:
                    customerLoan.setIdCardPositive(filePath);
                    customerLoanService.update(customerLoan);
                    break;
                case 7:
                    customerLoan.setIdCardBack(filePath);
                    customerLoanService.update(customerLoan);
                    break;
                default:
                    dealLoanSon(id, customerLoan.getId(), filePath, statue);
            }
        } else {
            customerLoan = new CustomerLoan();
            customerLoan.setCustomerId(customerTemp.getId());
            switch (statue) {
                case 6:
                    customerLoan.setIdCardPositive(filePath);
                    customerLoanService.add(customerLoan);
                    break;
                case 7:
                    customerLoan.setIdCardBack(filePath);
                    customerLoanService.add(customerLoan);
                    break;
                default:
                    customerLoanService.add(customerLoan);
                    dealLoanSon(id, customerLoan.getId(), filePath, statue);
            }
        }
        JSONObject result = new JSONObject();
        result.put("imagePath", filePath);
        ResponseUtil.write(response, result);
        return null;
    }

    public void dealLoanSon(int id, int loanInfoId, String path, int type) {
        CustomerLoanSon cls = new CustomerLoanSon();
        cls.setPath(path);
        if (id != 0) {
            cls.setId(id);
            customerLoanSonService.update(cls);
        } else {
            cls.setType(type);
            cls.setLoanInfoId(loanInfoId);
            customerLoanSonService.add(cls);
        }
    }
}
