package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pInvest;

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
}
