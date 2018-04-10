package com.wyh.p2p.entities;

import java.util.Date;

/**
 * 贷款项目类
 * 
 * @author laughing
 * 
 */
public class LoanItems {

	// ID
	private Integer id;

	// 额度上限
	private int moneyUp;

	// 额度下限
	private int moneyDown;

	// 利率
	private float rate;

	// 逾期利率
	private float overRate;

	// 期限上限
	private int dayUp;

	// 期限下限
	private int dayDown;

	// 创建时间
	private Date creatTime;

	// 是否发布
	private int releaseNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMoneyUp() {
		return moneyUp;
	}

	public void setMoneyUp(int moneyUp) {
		this.moneyUp = moneyUp;
	}

	public int getMoneyDown() {
		return moneyDown;
	}

	public void setMoneyDown(int moneyDown) {
		this.moneyDown = moneyDown;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getOverRate() {
		return overRate;
	}

	public void setOverRate(float overRate) {
		this.overRate = overRate;
	}

	public int getDayUp() {
		return dayUp;
	}

	public void setDayUp(int dayUp) {
		this.dayUp = dayUp;
	}

	public int getDayDown() {
		return dayDown;
	}

	public void setDayDown(int dayDown) {
		this.dayDown = dayDown;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public int getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(int releaseNum) {
		this.releaseNum = releaseNum;
	}

}
