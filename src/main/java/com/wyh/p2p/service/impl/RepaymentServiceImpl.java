package com.wyh.p2p.service.impl;

import com.github.pagehelper.PageHelper;
import com.wyh.p2p.generator.entities.P2pRepayment;
import com.wyh.p2p.generator.entities.P2pRepaymentExample;
import com.wyh.p2p.generator.mapperInterface.P2pRepaymentMapper;
import com.wyh.p2p.generator.mapperInterface.ext.RepaymentMapper;
import com.wyh.p2p.service.RepaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/22 下午3:32
 **/
@Service
public class RepaymentServiceImpl implements RepaymentService {

    private Logger logger = Logger.getLogger(RepaymentServiceImpl.class);

    @Autowired
    private P2pRepaymentMapper repaymentMapper;

    @Autowired
    private RepaymentMapper myRepaymentMapper;

    @Override
    public boolean add(P2pRepayment p2pRepayment) {
        try{
        return  repaymentMapper.insertSelective(p2pRepayment) > 0;
        }catch (Exception e){
            logger.error("add 还款信息出错！error:"+e);
            throw new RuntimeException("add 还款信息出错!");
        }
    }

    @Override
    public List<P2pRepayment> list(int page,int rows) {
        try{
            P2pRepaymentExample example = new P2pRepaymentExample();
            example.createCriteria().andResidueMoneyNotEqualTo((double)0);
            PageHelper.startPage(page,rows);
            return repaymentMapper.selectByExample(example);
        }catch (Exception e){
            logger.error("admin list 还款信息出错！error"+e);
            throw new RuntimeException("list 还款信息出错！");
        }
    }

    @Override
    public List<P2pRepayment> list(Integer id) {
        try{
            P2pRepaymentExample example = new P2pRepaymentExample();
            example.createCriteria().andUidEqualTo(id).andResidueMoneyNotEqualTo((double)0);
            return repaymentMapper.selectByExample(example);
        }catch (Exception e){
            logger.error("user list 还款信息出错！uid:"+id+"error:"+e);
            throw new RuntimeException("user list 还款信息出错！uid:"+id);
        }
    }

    @Override
    public P2pRepayment getById(int repayId) {
        try {
            return repaymentMapper.selectByPrimaryKey(repayId);
        }catch (Exception e){
            logger.error("getById error! repayId :"+repayId+e);
            throw new RuntimeException("getById error! repayId :"+repayId);
        }
    }

    @Override
    public boolean repayMoney(Integer id, double repayMoney, Integer repayPeriods) {
        try {
            return myRepaymentMapper.repayMoney(id,repayMoney,repayPeriods) > 0;
        }catch (Exception e){
            logger.error("repayMoney 还款出错！id:"+id+"还款金额："+repayMoney+"还款期数："+repayPeriods+"error!"+e);
            throw new RuntimeException("repayMoney 还款出错！id:"+id+"还款金额："+repayMoney+"还款期数："+repayPeriods);
        }
    }
}
