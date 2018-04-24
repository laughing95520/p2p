package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.AdminDao;
import com.wyh.p2p.entities.Admin;
import com.wyh.p2p.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;

	@Override
	public Admin getAdminByName(String name) {
		return adminDao.getAdminByName(name);
	}

	@Override
	public List<Admin> list(Map<String, Object> map) {
		return adminDao.list(map);
	}

	@Override
	public Long getTotle() {
		return adminDao.getTotle();
	}

	@Override
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	public void add(Admin admin) {
		adminDao.add(admin);
	}

	@Override
	public void del(int parseInt) {
		adminDao.del(parseInt);
	}
}
