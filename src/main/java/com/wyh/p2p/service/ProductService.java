package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pProduct;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/18 下午4:00
 **/
public interface ProductService {

    /**
     * 用户主页查看投资产品列表
     * @param i
     * @return
     */
    List<P2pProduct> viewList(int i);

    /**
     * 管理员分页查看投资产品
     * @param page 页数
     * @param rows 行数
     * @return
     */
    List<P2pProduct> pageList(int page, int rows);

    /**
     * 添加投资产品
     * @param p2pProduct
     * @return
     */
    boolean save(P2pProduct p2pProduct);

    /**
     * 批量删除投资产品
     * @param idList
     * @return
     */
    boolean delIds(List<Integer> idList);

    /**
     * 批量更改发布状态
     * @param idArr
     * @param state 0发布 1关闭
     * @return
     */
    boolean updateState(List<Integer> idArr, byte state);

    /**
     * 根据ID 获取产品信息
     * @param pid
     * @return
     */
    P2pProduct getProById(int pid);


    /**
     * 投资后更改产品投资金额
     * @param id
     * @param investMoney
     * @return
     */
    boolean update(Integer id, double investMoney);
}
