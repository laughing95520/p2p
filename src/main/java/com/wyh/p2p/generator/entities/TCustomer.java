package com.wyh.p2p.generator.entities;

import java.util.Date;

public class TCustomer {
    private Integer fid;

    private String fname;

    private Date fbirthday;

    private String fsex;

    private Long fidNum;

    private Long fphoneNum;

    private String faddress;

    private String fbanknum;

    private Long furgentPersonPhone;

    private String fpassword;

    private Double balance;

    private Double income;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Date getFbirthday() {
        return fbirthday;
    }

    public void setFbirthday(Date fbirthday) {
        this.fbirthday = fbirthday;
    }

    public String getFsex() {
        return fsex;
    }

    public void setFsex(String fsex) {
        this.fsex = fsex == null ? null : fsex.trim();
    }

    public Long getFidNum() {
        return fidNum;
    }

    public void setFidNum(Long fidNum) {
        this.fidNum = fidNum;
    }

    public Long getFphoneNum() {
        return fphoneNum;
    }

    public void setFphoneNum(Long fphoneNum) {
        this.fphoneNum = fphoneNum;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress == null ? null : faddress.trim();
    }

    public String getFbanknum() {
        return fbanknum;
    }

    public void setFbanknum(String fbanknum) {
        this.fbanknum = fbanknum == null ? null : fbanknum.trim();
    }

    public Long getFurgentPersonPhone() {
        return furgentPersonPhone;
    }

    public void setFurgentPersonPhone(Long furgentPersonPhone) {
        this.furgentPersonPhone = furgentPersonPhone;
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword == null ? null : fpassword.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}