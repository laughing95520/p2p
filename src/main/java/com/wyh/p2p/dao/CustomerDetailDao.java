package com.wyh.p2p.dao;

import com.wyh.p2p.entities.CustomerDetail;

import java.util.List;
import java.util.Map;


/**
 * 客户详情信息Dao层
 * 
 * @author Administrator
 * 
 */
public interface CustomerDetailDao {

	public List<CustomerDetail> list(Map<String, Object> map);

	/**
	 * 获得数量
	 * 
	 * @return
	 */
	public Long getTotle();

	public void del(int parseInt);

	public boolean checkInfo(Integer id);

	public CustomerDetail getOneById(Integer id);

	public void update(CustomerDetail customerDetail);

	public void add(CustomerDetail customerDetail);

}