package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CustomerLoanDao;
import com.wyh.p2p.entities.CustomerLoan;
import com.wyh.p2p.service.CustomerLoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("customerLoanService")
public class CustomerLoanServiceImpl implements CustomerLoanService {

	@Resource
	private CustomerLoanDao customerLoanDao;

	public List<CustomerLoan> list(Map<String, Object> map) {
		return customerLoanDao.list(map);
	}

	public Long getTotle() {
		return customerLoanDao.getTotle();
	}

	public void approval(Map<String, Object> map) {
		customerLoanDao.approval(map);
	}

	public boolean checkInfo(Integer id) {
		if (customerLoanDao.checkApply(id) != null && customerLoanDao.checkApply(id) == 1) {
			return true;
		}
		return false;
	}

	public CustomerLoan getByCustomerId(int id) {
		return customerLoanDao.getByCustomerId(id);
	}

	public void update(CustomerLoan customerLoan) {
		customerLoanDao.update(customerLoan);
	}

	public int add(CustomerLoan customerLoan) {
		return customerLoanDao.add(customerLoan);
	}

	public CustomerLoan getById(String id) {
		return customerLoanDao.getById(id);
	}

}
