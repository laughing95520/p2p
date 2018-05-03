package com.wyh.p2p.service;

import com.wyh.p2p.entities.pojo.InvestPojo;
import com.wyh.p2p.generator.entities.P2pInvest;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/20 下午7:57
 **/

public interface InvestService {
    /**
     * 新增用户投资记录
     * @param p2pInvest
     * @return
     */
    boolean addInvest(P2pInvest p2pInvest);

    /**
     * 用户投资记录列表
     * @param id
     * @return
     */
    List<InvestPojo> getList(Integer id);

    /**
     * 管理员分页获取用户投资列表
     * @param pages
     * @param rows
     * @return
     */
    List<InvestPojo> pageList(int pages, int rows);

    /**
     * 根据iid获得投资记录
     * @param id
     * @return
     */
    P2pInvest getByIid(int id);

    /**
     * 根据id更改投资记录的状态
     * @param iid
     * @return
     */
    boolean changeState(int iid);
}
