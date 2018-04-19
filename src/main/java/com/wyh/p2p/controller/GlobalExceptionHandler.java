package com.wyh.p2p.controller;

import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangyihang
 * @date 2018/4/18 下午10:23
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    ModelAndView resolveException(HttpRequest request1, HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error(e);
        HttpHeaders headers = request1.getHeaders();
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            System.out.println("AJAX请求..");
            JSONObject result = new JSONObject();
            result.put("success", false);
            try {
                ResponseUtil.write(response, result);
            }catch (IOException ioE){
            }
            return null;
        }else{
            ModelAndView mv = new ModelAndView();
            mv.addObject("error","error");
            mv.setViewName("error");
            return mv;
        }
    }
}
