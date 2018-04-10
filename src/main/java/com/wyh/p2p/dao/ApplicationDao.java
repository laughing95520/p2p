package com.wyh.p2p.dao;

import com.wyh.p2p.entities.Application;

import java.util.List;
import java.util.Map;



/**
 * 管理员Dao层
 * 
 * @author Administrator
 * 
 */
public interface ApplicationDao {

	public List<Application> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @param map
	 * 
	 * @return
	 */
	public Long getTotle(Map<String, Object> map);

	public void approval(Map<String, Object> map);

	public void add(Application application);

	public Integer getTotleMoney(int id);

	public Integer loanNum(Map<String, Object> map);

	public List<Application> loanList(Integer id);
}