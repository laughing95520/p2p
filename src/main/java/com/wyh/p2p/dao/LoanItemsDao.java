package com.wyh.p2p.dao;

import com.wyh.p2p.entities.LoanItems;

import java.util.List;
import java.util.Map;


/**
 * 贷款项目
 * 
 * @author Administrator
 * 
 */
public interface LoanItemsDao {

	public List<LoanItems> viewlist();

	public List<LoanItems> list(Map<String, Object> map);

	public Long getTotal();

	public void save(LoanItems loanItems);

	public void del(int id);

	public void release(int id, int release);

	public void release(Map<String, Object> map);

	public LoanItems getLoanItemsById(String id);

}