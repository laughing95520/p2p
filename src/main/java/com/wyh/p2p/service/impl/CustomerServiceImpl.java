package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CustomerDao;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.util.ParamUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;

	public List<Customer> list(Map<String, Object> map) {
		return customerDao.list(map);
	}

	public Long getTotle() {
		return customerDao.getTotle();
	}

	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}

	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	public Long getCustomerByName(String userName) {
		return customerDao.getCustomerByName(userName);
	}

	public void del(int parseInt) {
		customerDao.del(parseInt);
	}

	public boolean checkInfo(Customer customer) {
		return ParamUtil.isNull(customer);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}
}
