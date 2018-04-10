package com.wyh.p2p.service;

import com.wyh.p2p.entities.CustomerDetail;

import java.util.List;
import java.util.Map;



/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface CustomerDetailService {

	public List<CustomerDetail> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void del(int parseInt);

	public boolean checkInfo(Integer id);

	public CustomerDetail getInfo(int id);

	public void update(CustomerDetail customerDetail);

	public void add(CustomerDetail customerDetail);
}
