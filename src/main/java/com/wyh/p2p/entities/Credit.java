package com.wyh.p2p.entities;

/**
 * 客户信用类
 * 
 * @author laughing
 * 
 */
public class Credit {

	// ID
	private int id;

	// 用户名
	private String name;

	// 用户ID
	private int userId;

	// 客户信用
	private int credit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
