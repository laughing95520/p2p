package com.wyh.p2p.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wyh.p2p.generator.entities.P2pProduct;
import com.wyh.p2p.service.ProductService;
import com.wyh.p2p.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyihang
 * 投资产品
 */
@Controller
@RequestMapping("/admin/product")
public class ProductsAdminController {

    private static Logger logger = Logger.getLogger(ProductsAdminController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(@RequestParam("page") String page, @RequestParam("rows") String rows,
                       HttpServletResponse response) {
        try {
            List<P2pProduct> products = productService.pageList(Integer.parseInt(page), Integer.parseInt(rows));
            PageInfo<P2pProduct> p = new PageInfo<P2pProduct>(products);
            JSONObject res = new JSONObject();
            JsonConfig jsonConfig = new JsonConfig();
            JSONArray jsonArray = JSONArray.fromObject(products, jsonConfig);
            res.put("rows", jsonArray);
            res.put("total", p.getTotal());
            res.put("pages", p.getPages());
            ResponseUtil.write(response, res);
        } catch (Exception e) {
            logger.error("list投资产品 error" + e);
        }
        return null;
    }

    @RequestMapping("save")
    public void save(HttpServletResponse response, P2pProduct p2pProduct)
            throws Exception {
        JSONObject result = new JSONObject();
        boolean flag = false;
        try {
            if (checkParam(p2pProduct)) {
                flag = productService.save(p2pProduct);
            }
        } catch (Exception e) {
            flag = false;
        } finally {
            result.put("success", flag);
            ResponseUtil.write(response, result);
        }
    }

    @RequestMapping("del")
    public void del(HttpServletResponse response, @RequestParam("ids") String ids) throws IOException {
        JSONObject result = new JSONObject();
        boolean flag = false;
        try {
            String[] idArr = ids.split(",");
            List<Integer> idList = new ArrayList<Integer>(10);
            for (String temp : idArr
                    ) {
                int idTemp = Integer.parseInt(temp);
                idList.add(idTemp);
            }
            flag = productService.delIds(idList);
        } catch (Exception e) {
            logger.error("del 投资产品出错！" + e);
        } finally {
            result.put("success", flag);
            ResponseUtil.write(response, result);
        }
    }

    @RequestMapping("/release")
    public void release(HttpServletResponse response, @RequestParam("ids") String ids,
                          @RequestParam("release") String release) throws Exception {
        boolean flag = false;
        JSONObject result = new JSONObject();
        List<Integer> idArr = new ArrayList<Integer>(10);
        try {
            String[] id = ids.split(",");
            for (String tempId : id) {
                int idTemp = Integer.parseInt(tempId);
                idArr.add(idTemp);
            }
            byte state = Byte.parseByte(release);
            flag = productService.updateState(idArr, state);
        }catch (Exception e){
            logger.error("Controller release error"+e);
            flag = false;
        }finally {
            result.put("success", flag);
            ResponseUtil.write(response, result);
        }
    }

    private boolean checkParam(P2pProduct p2pProduct) {
        try {
            if (p2pProduct != null) {
                Double.valueOf(p2pProduct.getLowestMoney());
                Float.valueOf(p2pProduct.getRate());
                Integer.valueOf(p2pProduct.getTimeline());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
