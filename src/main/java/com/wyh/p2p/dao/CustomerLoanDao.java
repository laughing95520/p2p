package com.wyh.p2p.dao;

import com.wyh.p2p.entities.CustomerLoan;

import java.util.List;
import java.util.Map;


/**
 * 客户贷款资料Dao层
 * 
 * @author Administrator
 * 
 */
public interface CustomerLoanDao {

	public List<CustomerLoan> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void approval(Map<String, Object> map);

	public Integer checkApply(int id);

	public CustomerLoan getByCustomerId(int id);

	public void update(CustomerLoan customerLoan);

	public int add(CustomerLoan customerLoan);

	public CustomerLoan getById(String id);

}