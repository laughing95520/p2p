package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pRate;

import java.util.List;


/**
 * 贷款利息管理service接口
 * 
 * @author Administrator
 * 
 */
public interface LoanRateService {
	/**
	 * 获取利率列表
	 * @return
	 */
	List<P2pRate> list();

	/**
	 * 添加利率信息
	 * @param p2pRate
	 * @return
	 */
	boolean save(P2pRate p2pRate);

	/**
	 * 批量删除贷款利率
	 * @param idlist
	 * @return
	 */
	boolean del(List<Integer> idlist);

	/**
	 * 通过id获取利率
	 * @param intId
	 * @return
	 */
    P2pRate getRateById(int intId);
}
