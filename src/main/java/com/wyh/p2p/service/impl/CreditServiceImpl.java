package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CreditDao;
import com.wyh.p2p.entities.Credit;
import com.wyh.p2p.service.CreditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("CreditService")
public class CreditServiceImpl implements CreditService {

	@Resource
	private CreditDao creditDao;

	@Override
	public List<Credit> list(Map<String, Object> map) {
		return creditDao.list(map);
	}

	@Override
	public Long getTotle() {
		return creditDao.getTotle();
	}

	@Override
	public void update(Credit credit) {
		creditDao.update(credit);
	}

	@Override
	public void del(int parseInt) {
		creditDao.del(parseInt);
	}

	@Override
	public void add(Credit credit) {
		creditDao.add(credit);
	}

	@Override
	public Credit getByCustomerId(Integer id) {
		return creditDao.getByCustomerId(id);
	}
}
