package com.wyh.p2p.generator.entities;

public class P2pRepayment {
    private Integer id;

    private Double residueMoney;

    private Integer loanId;

    private Double loanMoney;

    private Double payMoney;

    private Integer uid;

    private Integer repayPeriods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getResidueMoney() {
        return residueMoney;
    }

    public void setResidueMoney(Double residueMoney) {
        this.residueMoney = residueMoney;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRepayPeriods() {
        return repayPeriods;
    }

    public void setRepayPeriods(Integer repayPeriods) {
        this.repayPeriods = repayPeriods;
    }
}