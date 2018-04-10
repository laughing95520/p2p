package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CustomerLoanSonDao;
import com.wyh.p2p.entities.CustomerLoanSon;
import com.wyh.p2p.service.CustomerLoanSonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service("customerLoanSonService")
public class CustomerLoanSonServiceImpl implements CustomerLoanSonService {

	@Resource
	private CustomerLoanSonDao customerLoanSonDao;

	public List<CustomerLoanSon> getFileType(int type, int id) {
		return customerLoanSonDao.getFileType(type, id);
	}

	public void update(CustomerLoanSon cls) {
		customerLoanSonDao.update(cls);
	}

	public void add(CustomerLoanSon cls) {
		customerLoanSonDao.add(cls);
	}

}
