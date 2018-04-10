package com.wyh.p2p.service;

import com.wyh.p2p.entities.CustomerLoan;

import java.util.List;
import java.util.Map;


/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface CustomerLoanService {

	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @return
	 */
	public List<CustomerLoan> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void approval(Map<String, Object> map);

	public boolean checkInfo(Integer id);

	public CustomerLoan getByCustomerId(int id);

	public void update(CustomerLoan customerLoan);

	public int add(CustomerLoan customerLoan);

	public CustomerLoan getById(String id);

}
