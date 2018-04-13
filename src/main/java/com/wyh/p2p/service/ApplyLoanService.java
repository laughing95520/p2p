package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pLoan;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/9 上午10:44
 * 贷款申请
 **/
public interface ApplyLoanService {

    /**
     * 添加贷款申请
     * @param p2pLoan
     */
    boolean insertApply(P2pLoan p2pLoan);

    /**
     * 查看用户贷款信息
     * @param cusId
     * @return
     */
    List<P2pLoan> findByCusId(int cusId);

    /**
     * 贷款申请列表
     * @return
     */
    List<P2pLoan> list(int page,int rows);

    /**
     * 审核贷款申请
     * @param loanId
     * @param state
     * @param words
     * @return
     */
    boolean changeLoan(int loanId, byte state, String words);
}
