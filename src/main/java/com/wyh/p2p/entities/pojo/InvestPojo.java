package com.wyh.p2p.entities.pojo;

import java.util.Date;

/**
 * @author wangyihang
 * @date 2018/5/2 下午2:04
 **/
public class InvestPojo {

    /**
     * 投资记录id
     */
    private int id;

    /**
     * 用户id
     */
    private int uid;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 投资产品pid
     */
    private int pid;

    /**
     * 投资基金名字
     */
    private String title;

    /**
     * 投资基金利率
     */
    private Float rate;

    /**
     * 用户投资金额
     */
    private Double investMoney;

    /**
     * 用户收益金额
     */
    private Double income;

    /**
     * 用户收益时间
     */
    private Date incomeDate;

    /**
     * 状态
     */
    private Byte state;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Double getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(Double investMoney) {
        this.investMoney = investMoney;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
