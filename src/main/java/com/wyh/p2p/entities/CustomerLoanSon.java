package com.wyh.p2p.entities;

public class CustomerLoanSon {

	// 主键
	private int id;

	// 路径
	private String path;

	// 贷款资料的ID
	private int loanInfoId;

	// 类型 1：收入证明 2： 房产证 3：信用报告 4： 工资条 5：工作证
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLoanInfoId() {
		return loanInfoId;
	}

	public void setLoanInfoId(int loanInfoId) {
		this.loanInfoId = loanInfoId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
