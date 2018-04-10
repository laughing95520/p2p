package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.ApplicationDao;
import com.wyh.p2p.entities.Application;
import com.wyh.p2p.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	@Resource
	private ApplicationDao applicationDao;

	public List<Application> list(Map<String, Object> map) {
		return applicationDao.list(map);
	}

	public Long getTotle(Map<String, Object> map) {
		return applicationDao.getTotle(map);
	}

	public void approval(Map<String, Object> map) {
		applicationDao.approval(map);
	}

	public void add(Application application) {
		applicationDao.add(application);
	}

	public int getTotleMoney(int id) {
		return applicationDao.getTotleMoney(id);
	}

	public int loanNum(Map<String, Object> map) {
		return applicationDao.loanNum(map);
	}

	public List<Application> loanList(Integer id) {
		return applicationDao.loanList(id);
	}
}
