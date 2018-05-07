package com.wyh.p2p.generator.entities;

import java.io.Serializable;
import java.util.Date;

public class P2pLoan implements Serializable{

    private static final long serialVersionUID = -4814150619153918089L;

    private Integer id;

    private Float rate;

    private Integer loanMonth;

    private Integer guaranteeId;

    private Double money;

    private Byte state;

    private Byte repayWay;

    private String words;

    private Integer customerId;

    private Double interest;

    private Date loanTime;

    private Date lendingTime;

    private String processInstanceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Integer getLoanMonth() {
        return loanMonth;
    }

    public void setLoanMonth(Integer loanMonth) {
        this.loanMonth = loanMonth;
    }

    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getRepayWay() {
        return repayWay;
    }

    public void setRepayWay(Byte repayWay) {
        this.repayWay = repayWay;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words == null ? null : words.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public Date getLendingTime() {
        return lendingTime;
    }

    public void setLendingTime(Date lendingTime) {
        this.lendingTime = lendingTime;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }
}