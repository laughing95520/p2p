package com.wyh.p2p.service;

import com.wyh.p2p.entities.LoanItems;

import java.util.List;
import java.util.Map;


/**
 * 客户service接口
 * 
 * @author Administrator
 * 
 */
public interface LoanItemsService {

	public List<LoanItems> viewlist();

	public List<LoanItems> list(Map<String, Object> map);

	public Long getTotal();

	public void save(LoanItems loanItems);

	public void del(int id);

	public void release(Map<String, Object> map);

	public LoanItems getLoanItemsById(String id);
}
