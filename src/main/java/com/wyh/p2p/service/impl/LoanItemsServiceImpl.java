package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.LoanItemsDao;
import com.wyh.p2p.entities.LoanItems;
import com.wyh.p2p.service.LoanItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service("loanItemsService")
public class LoanItemsServiceImpl implements LoanItemsService {

	@Resource
	private LoanItemsDao loanItemsDao;

	public List<LoanItems> viewlist() {
		return loanItemsDao.viewlist();
	}

	public List<LoanItems> list(Map<String, Object> map) {
		return loanItemsDao.list(map);
	}

	public Long getTotal() {
		return loanItemsDao.getTotal();
	}

	public void save(LoanItems loanItems) {
		loanItemsDao.save(loanItems);
	}

	public void del(int id) {
		loanItemsDao.del(id);
	}

	public void release(Map<String, Object> map) {
		loanItemsDao.release(map);
	}

	public LoanItems getLoanItemsById(String id) {
		return loanItemsDao.getLoanItemsById(id);
	}

}
