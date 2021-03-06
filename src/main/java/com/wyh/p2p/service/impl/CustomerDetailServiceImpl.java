package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CustomerDetailDao;
import com.wyh.p2p.entities.CustomerDetail;
import com.wyh.p2p.service.CustomerDetailService;
import com.wyh.p2p.util.ParamUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service("customerDetailService")
public class CustomerDetailServiceImpl implements CustomerDetailService {

	@Resource
	private CustomerDetailDao customerDetailDao;

	@Override
	public List<CustomerDetail> list(Map<String, Object> map) {
		return customerDetailDao.list(map);
	}

	@Override
	public Long getTotle() {
		return customerDetailDao.getTotle();
	}

	@Override
	public void del(int parseInt) {
		customerDetailDao.del(parseInt);
	}

	@Override
	public boolean checkInfo(Integer id) {
		CustomerDetail customerDetail = customerDetailDao.getOneById(id);
		return ParamUtil.isNull(customerDetail);
	}

	@Override
	public CustomerDetail getInfo(int id) {
		return customerDetailDao.getOneById(id);
	}

	@Override
	public void update(CustomerDetail customerDetail) {
		customerDetailDao.update(customerDetail);
	}

	@Override
	public void add(CustomerDetail customerDetail) {
		customerDetailDao.add(customerDetail);
	}
}
