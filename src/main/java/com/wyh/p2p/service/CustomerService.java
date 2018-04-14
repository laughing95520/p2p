package com.wyh.p2p.service;

import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.generator.entities.TCustomer;

import java.util.List;
import java.util.Map;

/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface CustomerService {

	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Customer> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public Customer login(Customer customer);

	public int add(Customer customer);

	public Long getCustomerByName(String userName);

	public void del(int parseInt);

	public boolean checkInfo(Customer customer);

	public void update(Customer customer);

	public Customer getCustomerById(Integer id);

	boolean updateById(TCustomer customer);

	boolean addBalance(Double money, Integer customerId);
}
