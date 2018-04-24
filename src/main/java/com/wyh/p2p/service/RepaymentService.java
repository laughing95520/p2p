package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pRepayment;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/22 下午3:31
 **/
public interface RepaymentService {

    /**
     * 新增还款信息
     * @param p2pRepayment
     * @return
     */
    boolean add(P2pRepayment p2pRepayment);

    /**
     * 管理员获取还款信息列表
     * @return
     */
    List<P2pRepayment> list(int page,int rows);

    /**
     * 用户还款列表
     * @param uid
     * @return
     */
    List<P2pRepayment> list(Integer uid);

    /**
     * 根据id 获取还款信息
     * @param repayId
     * @return
     */
    P2pRepayment getById(int repayId);

    /**
     * 还款表执行还款操作
     * @param id
     * @param repayMoney
     * @param repayPeriods
     * @return
     */
    boolean repayMoney(Integer id, double repayMoney, Integer repayPeriods);
}
