package com.wyh.p2p.service;

import com.wyh.p2p.entities.CustomerLoanSon;

import java.util.List;


/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface CustomerLoanSonService {

	public List<CustomerLoanSon> getFileType(int type, int id);

	public void update(CustomerLoanSon cls);

	public void add(CustomerLoanSon cls);
}
