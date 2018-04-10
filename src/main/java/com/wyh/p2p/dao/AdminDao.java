package com.wyh.p2p.dao;

import com.wyh.p2p.entities.Admin;

import java.util.List;
import java.util.Map;

/**
 * 管理员Dao层
 * 
 * @author Administrator
 * 
 */
public interface AdminDao {

	/**
	 * 通过用户名获取用户
	 * 
	 * @param name
	 * @return
	 */
	public Admin getAdminByName(String name);

	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Admin> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void update(Admin admin);

	public void add(Admin admin);

	public void del(int parseInt);
}