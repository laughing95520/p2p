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

	public List<Credit> list(Map<String, Object> map) {
		return creditDao.list(map);
	}

	public Long getTotle() {
		return creditDao.getTotle();
	}

	public void update(Credit credit) {
		creditDao.update(credit);
	}

	public void del(int parseInt) {
		creditDao.del(parseInt);
	}

	public void add(Credit credit) {
		creditDao.add(credit);
	}

	public Credit getByCustomerId(Integer id) {
		return creditDao.getByCustomerId(id);
	}
}
