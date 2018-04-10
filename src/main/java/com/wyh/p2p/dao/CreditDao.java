package com.wyh.p2p.dao;


import com.wyh.p2p.entities.Credit;

import java.util.List;
import java.util.Map;

/**
 * 管理员Dao层
 * 
 * @author Administrator
 * 
 */
public interface CreditDao {

	public List<Credit> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void update(Credit credit);

	public void del(int id);

	public void add(Credit credit);

	public Credit getByCustomerId(Integer id);
}