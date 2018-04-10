package com.wyh.p2p.dao;

import com.wyh.p2p.entities.CustomerLoanSon;

import java.util.List;


public interface CustomerLoanSonDao {

	List<CustomerLoanSon> getFileType(int type, int id);

	void update(CustomerLoanSon cls);

	void add(CustomerLoanSon cls);

}
