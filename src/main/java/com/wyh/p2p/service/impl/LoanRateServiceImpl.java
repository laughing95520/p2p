package com.wyh.p2p.service.impl;

import com.wyh.p2p.generator.entities.P2pRate;
import com.wyh.p2p.generator.entities.P2pRateExample;
import com.wyh.p2p.generator.mapperInterface.P2pRateMapper;
import com.wyh.p2p.service.LoanRateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LoanRateServiceImpl implements LoanRateService {

	private static Logger logger = Logger.getLogger(LoanRateServiceImpl.class);

	@Autowired
	private P2pRateMapper p2pRateMapper;

	@Override
	public List<P2pRate> list() {
		try {
			P2pRateExample example  = new P2pRateExample();
			example.setOrderByClause("rate");
			return p2pRateMapper.selectByExample(example);
		}catch (Exception e){
			logger.error("list 贷款利率表出错！"+e);
			throw new RuntimeException("list 贷款利率表出错！");
		}
	}

	@Override
	public boolean save(P2pRate p2pRate) {
		try {
			return p2pRateMapper.insertSelective(p2pRate) > 0;
		}catch (Exception e){
			logger.error("save 贷款利率信息出错！"+e);
			throw new RuntimeException("save 贷款利率信息出错！");
		}
	}

	@Override
	public P2pRate getRateById(int intId) {
		try{
			return p2pRateMapper.selectByPrimaryKey(intId);
		}catch (Exception e){
			logger.error("getRateById 根据id获取利率错误,id"+intId);
			throw new RuntimeException("getRateById 根据id获取利率错误,id");
		}
	}

	@Override
	public boolean del(List<Integer> idlist) {
		try{
			P2pRateExample example = new P2pRateExample();
			example.createCriteria().andIdIn(idlist);
			return p2pRateMapper.deleteByExample(example) > 0;
		}catch (Exception e){
			logger.error("del 贷款利率信息出错！"+e);
			throw new RuntimeException("del 贷款利率信息出错！");
		}
	}
}
