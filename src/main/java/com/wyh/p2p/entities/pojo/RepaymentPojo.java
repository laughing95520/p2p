package com.wyh.p2p.entities.pojo;

import java.util.Date;

/**
 * @author wangyihang
 * @date 2018/4/22 下午6:04
 **/
public class RepaymentPojo {

    /**
     * 还款信息id
     */
    private int id;

    /**
     * 用户id
     */
    private int uid;

    /**
     * 贷款信息id
     */
    private int loanId;

    /**
     * 贷款用户名
     */
    private String customerName;

    /**
     * 贷款总金额
     */
    private double loanMoney;

    /**
     * 放贷时间
     */
    private Date lendTime;

    /**
     * 贷款期限
     */
    private int loanMonth;

    /**
     * 需还款总金额
     */
    private double payMoney;

    /**
     * 剩余还款总金额
     */
    private double residueMoney;

    /**
     * 还款方式
     * 1:"按月付息，到期还本";
     * 2:"连本带息，到期一次还";
     */
    private byte payMethod;

    /**
     * 本期应还余额
     */
    private double repayMoneyNow;

    /**
     * 当前还款期数
     */
    private int repayPeriods;

    /**
     * 贷款利率
     */
    private float rate;

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public int getLoanMonth() {
        return loanMonth;
    }

    public void setLoanMonth(int loanMonth) {
        this.loanMonth = loanMonth;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public double getResidueMoney() {
        return residueMoney;
    }

    public void setResidueMoney(double residueMoney) {
        this.residueMoney = residueMoney;
    }

    public byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(byte payMethod) {
        this.payMethod = payMethod;
    }

    public double getRepayMoneyNow() {
        return repayMoneyNow;
    }

    public void setRepayMoneyNow(double repayMoneyNow) {
        this.repayMoneyNow = repayMoneyNow;
    }

    public int getRepayPeriods() {
        return repayPeriods;
    }

    public void setRepayPeriods(int repayPeriods) {
        this.repayPeriods = repayPeriods;
    }
}
