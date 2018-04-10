package com.wyh.p2p.service;

import com.wyh.p2p.entities.Credit;

import java.util.List;
import java.util.Map;

/**
 * 用户service接口
 * 
 * @author Administrator
 * 
 */
public interface CreditService {

	// /**
	// * 通过用户名查找用户
	// *
	// * @param Name
	// * @return
	// */
	// public Admin getAdminByName(String Name);

	// /**
	// * 通过id获取用户
	// *
	// * @param userName
	// * @return
	// */
	// public Blogger findById(Integer id);
	//
	// /**
	// * 更新用户信息
	// *
	// * @param blogger
	// * @return
	// */
	// public Integer update(Blogger blogger);
	//
	// /**
	// * 用户注册
	// *
	// * @param blogger
	// * @return
	// */
	// public Integer add(Blogger blogger);
	//
	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Credit> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void update(Credit credit);

	public void del(int parseInt);

	public void add(Credit credit);

	public Credit getByCustomerId(Integer id);
}
