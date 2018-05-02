package com.wyh.p2p.service.impl;

import com.wyh.p2p.dao.CustomerDao;
import com.wyh.p2p.entities.Customer;
import com.wyh.p2p.generator.entities.P2pMessage;
import com.wyh.p2p.generator.entities.P2pMessageExample;
import com.wyh.p2p.generator.entities.TCustomer;
import com.wyh.p2p.generator.mapperInterface.P2pMessageMapper;
import com.wyh.p2p.generator.mapperInterface.TCustomerMapper;
import com.wyh.p2p.service.CustomerService;
import com.wyh.p2p.util.ParamUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Resource
	private CustomerDao customerDao;

	@Autowired
	private TCustomerMapper tCustomerMapper;

	@Autowired
	private P2pMessageMapper p2pMessageMapper;

	@Override
	public List<Customer> list(Map<String, Object> map) {
		return customerDao.list(map);
	}

	@Override
	public Long getTotle() {
		return customerDao.getTotle();
	}

	@Override
	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}

	@Override
	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public Long getCustomerByName(String userName) {
		return customerDao.getCustomerByName(userName);
	}

	@Override
	public void del(int parseInt) {
		customerDao.del(parseInt);
	}

	@Override
	public boolean checkInfo(Customer customer) {
		return ParamUtil.isNull(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public boolean updateById(TCustomer customer) {
		return tCustomerMapper.updateByPrimaryKeySelective(customer) > 0;
	}

	@Override
	public boolean addBalance(Double money, Integer customerId) {
		return customerDao.addBalance(money, customerId) > 0;
	}

	@Override
	public boolean redBalance(double payMoney, int cusId) {
		return customerDao.redBalance(payMoney, cusId) > 0;
	}

	@Override
	public boolean addMessage(P2pMessage p2pMessage) {
		return p2pMessageMapper.insertSelective(p2pMessage) > 0;
	}

	@Override
	public List<P2pMessage> getMessageByUid(Integer id) {
		try {
			P2pMessageExample example = new P2pMessageExample();
			example.createCriteria().andUseridEqualTo(id).andStateEqualTo((byte) 1);
			return p2pMessageMapper.selectByExample(example);
		}catch (Exception e){
			logger.error("获得用户的还款提醒消息出错！uid:"+id+"error:"+e);
			throw new RuntimeException("获得用户的还款提醒消息出错！uid:"+id);
		}
	}

	@Override
	public boolean changeMessageState(List<Integer> ids,int uid) {
		try {
			P2pMessageExample example = new P2pMessageExample();
			example.createCriteria().andUseridEqualTo(uid).andIdIn(ids);
			P2pMessage message = new P2pMessage();
			message.setState((byte) 2);
			return p2pMessageMapper.updateByExampleSelective(message,example) > 0;
		}catch (Exception e){
			logger.error("更新还款提醒消息出错！uid:"+uid+"error:"+e);
			throw new RuntimeException("更新还款提醒消息出错！uid:"+uid);
		}
	}

	@Override
	public void addInvestMoney(double allMoney, double income, Integer uid) {
		//todo:add 用户余额和收益
	}
}
