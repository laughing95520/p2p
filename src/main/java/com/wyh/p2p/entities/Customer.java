package com.wyh.p2p.entities;

import java.util.Date;

/**
 * 客户类
 * 
 * @author laughing
 * 
 */
public class Customer {

	// ID
	private Integer id;

	// 用户名
	private String name;

	// 出生日期
	private Date birthday;

	// 性别
	private int sex;

	// 身份证号码
	private Long idNum;

	// 联系电话
	private Long phoneNum;

	// 地址（省+市）例 陕西省-西安市
	private String address;

	// 银行卡号
	private String fBankNum;


	// 基金联系人电话
	private Long urgentPersonPhone;

	// 密码
	private String password;

	//账户余额
	private Double balance;

	//账户收益
	private Double income;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Long getIdNum() {
		return idNum;
	}

	public void setIdNum(Long idNum) {
		this.idNum = idNum;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getfBankNum() {
		return fBankNum;
	}

	public void setfBankNum(String fBankNum) {
		this.fBankNum = fBankNum;
	}
	public Long getUrgentPersonPhone() {
		return urgentPersonPhone;
	}

	public void setUrgentPersonPhone(Long urgentPersonPhone) {
		this.urgentPersonPhone = urgentPersonPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
