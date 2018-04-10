package com.wyh.p2p.service;

import com.wyh.p2p.entities.Application;

import java.util.List;
import java.util.Map;

/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface ApplicationService {

	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @return
	 */
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

	public int getTotleMoney(int id);

	public int loanNum(Map<String, Object> map);

	public List<Application> loanList(Integer id);
}
