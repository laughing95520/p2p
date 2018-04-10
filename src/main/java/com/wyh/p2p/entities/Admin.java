package com.wyh.p2p.entities;

/**
 * 管理员类
 * 
 * @author laughing
 * 
 */
public class Admin {

	// ID
	private int id;

	// 用户名
	private String name;

	// 工号
	private int jobNum;

	// 密码
	private String pwd;

	// 是否为超级管理员
	private String statue;

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

	public int getJobNum() {
		return jobNum;
	}

	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

}
