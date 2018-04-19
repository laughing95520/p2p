package com.wyh.p2p.service.impl;

import com.github.pagehelper.PageHelper;
import com.wyh.p2p.generator.entities.P2pProduct;
import com.wyh.p2p.generator.entities.P2pProductExample;
import com.wyh.p2p.generator.mapperInterface.P2pProductMapper;
import com.wyh.p2p.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/18 下午4:06
 **/
@Service
public class ProductServiceImpl implements ProductService{

    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private P2pProductMapper productMapper;

    public List<P2pProduct> viewList(int i) {
        P2pProductExample p2pProductExample = new P2pProductExample();
        try {
            if (i == 0) {
                p2pProductExample.createCriteria().andStateEqualTo((byte) i);
            }
            return productMapper.selectByExample(p2pProductExample);
        } catch (Exception e) {
            logger.error("viewList 查询投资项目产品表出错！"+e);
            throw new RuntimeException("viewList 查询投资项目产品表出错！");
        }
    }

    public List<P2pProduct> pageList(int page, int rows) {
        P2pProductExample example = new P2pProductExample();
        try{
            PageHelper.startPage(page,rows);
            return productMapper.selectByExample(example);
        }catch (Exception e){
            logger.error("pageList 分页查询投资项目产品出错！"+e);
            throw new RuntimeException("pageList 分页查询投资项目产品出错");
        }
    }

    public boolean save(P2pProduct p2pProduct) {
        try {
            return productMapper.insertSelective(p2pProduct) > 0;
        }catch (Exception e){
            logger.error("添加投资产品出错！"+e);
            throw new RuntimeException("添加投资产品出错！");
        }
    }

    public boolean delIds(List<Integer> idList) {
        P2pProductExample example = new P2pProductExample();
        try{
            example.createCriteria().andIdIn(idList);
            return productMapper.deleteByExample(example) > 0;
        }catch (Exception e){
            logger.error("删除投资产品失败！"+e);
            throw new RuntimeException("删除投资产品delIds 失败！"+idList);
        }
    }

    public boolean updateState(List<Integer> idArr, byte state) {
        try {
            P2pProductExample example = new P2pProductExample();
            example.createCriteria().andIdIn(idArr);
            P2pProduct p2pProduct = new P2pProduct();
            p2pProduct.setState(state);
            return productMapper.updateByExampleSelective(p2pProduct, example) > 0;
        }catch (Exception e){
            logger.error("updateState 更新发布状态失败！"+e);
            throw new RuntimeException("updateState 更新发布状态失败！");
        }
    }
}
