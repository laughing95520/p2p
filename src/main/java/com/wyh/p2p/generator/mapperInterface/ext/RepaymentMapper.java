package com.wyh.p2p.generator.mapperInterface.ext;

import org.apache.ibatis.annotations.Param;

/**
 * @author wangyihang
 * @date 2018/4/24 下午3:22
 **/
public interface RepaymentMapper {
    /**
     * 还款
     * @param id 还款id
     * @param repayMoney 还款money
     * @param repayPeriods 还款期数
     * @return
     */
    int repayMoney(@Param("id")Integer id,@Param("repayMoney")double repayMoney,@Param("repayPeriods")Integer repayPeriods);
}
