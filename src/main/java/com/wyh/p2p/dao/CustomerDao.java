package com.wyh.p2p.dao;

import com.wyh.p2p.entities.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



/**
 * 客户基本信息Dao层
 * 
 * @author Administrator
 * 
 */
public interface CustomerDao {

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

	/**
	 * 用户登录
	 * 
	 * @param customer
	 * @return
	 */
	public Customer login(Customer customer);

	/**
	 * 用户注册
	 * 
	 * @param customer
	 */
	public int add(Customer customer);

	/**
	 * 检查该用户名是否已被注册
	 * 
	 * @param userName
	 * @return
	 */
	public Long getCustomerByName(String userName);

	public void del(int id);

	public void update(Customer customer);

	public Customer getCustomerById(Integer id);

	int addBalance(@Param("money") double money,@Param("cusId") int cusId);

    int redBalance(@Param("money") double money,@Param("cusId") int cusId);

	/**
	 * 归还用户投资
	 * @param balance
	 * @param income
	 * @param uid
	 * @return
	 */
	int addInvest(@Param("balance")double balance,@Param("income")double income,@Param("id") int uid);
}