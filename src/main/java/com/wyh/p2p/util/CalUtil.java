package com.wyh.p2p.util;

import com.wyh.p2p.entities.pojo.RepaymentPojo;

/**
 * @author wangyihang
 * @date 2018/4/23 上午10:30
 **/
public class CalUtil {
    /**
     * 计算当前期数应还金额
     * @param payMoney 需还款总金额
     * @param loanMoney 贷款本金总金额
     * @param loanMonth 贷款期限
     * @param repayPeriods 当前还款期数
     * @return
     */
    public static RepaymentPojo calRepayNow(Double payMoney, Double loanMoney, Integer loanMonth, Integer repayPeriods) {
        RepaymentPojo temp = new RepaymentPojo();
        double interest = payMoney - loanMoney;
        double monthMoney = interest/loanMonth;
        double repayNow;
        double residuMoney;
        if (repayPeriods.equals(loanMonth)){
            repayNow = monthMoney+loanMoney;
        }else{
            repayNow = monthMoney;
        }
        residuMoney = payMoney - (repayPeriods*monthMoney);
        temp.setRepayMoneyNow(repayNow);
        temp.setResidueMoney(residuMoney);
        return temp;
    }
}
