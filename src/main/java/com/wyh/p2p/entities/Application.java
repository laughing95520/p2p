package com.wyh.p2p.entities;

import java.util.Date;

/**
 * 贷款申请
 * 
 * @author laughing
 * 
 */
public class Application {

	// ID
	private Integer id;

	// 用户ID
	private Integer customerId;

	// 用户名
	private String name;

	// 贷款金额
	private Integer money;

	// 贷款天数
	private Integer day;

	// 利率
	private float interestRate;

	// 逾期利率
	private float overdueInterestRate;

	// 分期次数
	private Integer stageCount;

	// 申请日期
	private Date applyDate;

	// 审批人(普通)
	private String approverIdOrdinary;

	// 审批通过(普通)
	private String approvalOrdinary;

	// 审批日期(普通)
	private Date approvalDateOrdinary;

	// 审批人(超级)
	private String approverIdSuper;

	// 审批通过(超级)
	private String approvalSuper;

	// 审批日期(超级)
	private Date approvalDateSuper;

	// 审批人(财务)
	private String approverIdFinance;

	// 审批通过(财务)
	private String releaseA;

	// 发放日期
	private Date approvalDateFinance;

	// 不同原因
	private String reason;

	// 审批人姓名
	private String approvalName;

	private String statue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getOverdueInterestRate() {
		return overdueInterestRate;
	}

	public void setOverdueInterestRate(float overdueInterestRate) {
		this.overdueInterestRate = overdueInterestRate;
	}

	public Integer getStageCount() {
		return stageCount;
	}

	public void setStageCount(Integer stageCount) {
		this.stageCount = stageCount;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getApproverIdOrdinary() {
		return approverIdOrdinary;
	}

	public void setApproverIdOrdinary(String approverIdOrdinary) {
		this.approverIdOrdinary = approverIdOrdinary;
	}

	public String getApprovalOrdinary() {
		return approvalOrdinary;
	}

	public void setApprovalOrdinary(String approvalOrdinary) {
		this.approvalOrdinary = approvalOrdinary;
	}

	public Date getApprovalDateOrdinary() {
		return approvalDateOrdinary;
	}

	public void setApprovalDateOrdinary(Date approvalDateOrdinary) {
		this.approvalDateOrdinary = approvalDateOrdinary;
	}

	public String getApproverIdSuper() {
		return approverIdSuper;
	}

	public void setApproverIdSuper(String approverIdSuper) {
		this.approverIdSuper = approverIdSuper;
	}

	public String getApprovalSuper() {
		return approvalSuper;
	}

	public void setApprovalSuper(String approvalSuper) {
		this.approvalSuper = approvalSuper;
	}

	public Date getApprovalDateSuper() {
		return approvalDateSuper;
	}

	public void setApprovalDateSuper(Date approvalDateSuper) {
		this.approvalDateSuper = approvalDateSuper;
	}

	public String getApproverIdFinance() {
		return approverIdFinance;
	}

	public void setApproverIdFinance(String approverIdFinance) {
		this.approverIdFinance = approverIdFinance;
	}

	public String getReleaseA() {
		return releaseA;
	}

	public void setReleaseA(String releaseA) {
		this.releaseA = releaseA;
	}

	public Date getApprovalDateFinance() {
		return approvalDateFinance;
	}

	public void setApprovalDateFinance(Date approvalDateFinance) {
		this.approvalDateFinance = approvalDateFinance;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

}
