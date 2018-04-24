package com.wyh.p2p.service.impl;

import com.github.pagehelper.PageHelper;
import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pLoanExample;
import com.wyh.p2p.generator.mapperInterface.P2pLoanMapper;
import com.wyh.p2p.service.ApplyLoanService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/9 上午11:14
 **/

@Service
public class ApplyLoanServiceImpl implements ApplyLoanService {

    private static Logger logger = org.apache.log4j.Logger.getLogger(ApplyLoanServiceImpl.class);

    @Resource
    private P2pLoanMapper p2pLoanMapper;

    @Override
    public boolean insertApply(P2pLoan p2pLoan) {
        try {
            return p2pLoanMapper.insertSelective(p2pLoan)>0;
        }catch (Exception e){
            logger.error("insert p2pLoan error"+e);
            throw new RuntimeException("insertApply Error"+e);
        }
    }

    @Override
    public List<P2pLoan> findByCusId(int cusId) {
        try {
            P2pLoanExample example = new P2pLoanExample();
            example.createCriteria().andCustomerIdEqualTo(cusId);
            return p2pLoanMapper.selectByExample(example);
        }catch (Exception e){
            logger.error("findByCusId error"+e);
            throw new RuntimeException("findByCusId error");
        }
    }

    @Override
    public List<P2pLoan> list(int page,int rows) {
        try{
            P2pLoanExample example = new P2pLoanExample();
            example.setOrderByClause("loan_time DESC");
            PageHelper.startPage(page,rows);
            return p2pLoanMapper.selectByExample(example);
        }catch (Exception e){
            logger.error("贷款项目 list error"+e);
            throw new RuntimeException("贷款项目 list error");
        }
    }

    @Override
    public boolean changeLoan(int loanId, byte state, String words) {
        try{
            P2pLoan p2pLoan = new P2pLoan();
            p2pLoan.setId(loanId);
            p2pLoan.setState(state);
            p2pLoan.setWords(words);
            p2pLoan.setLendingTime(new Date());
            return p2pLoanMapper.updateByPrimaryKeySelective(p2pLoan) > 0;
        }catch (Exception e){
            logger.error("审核贷款项目出错loanId :"+loanId+"error:"+e);
            throw new RuntimeException("审核贷款项目出错loanId :"+loanId);
        }
    }

    @Override
    public P2pLoan findId(int loanId) {
        try{
            return p2pLoanMapper.selectByPrimaryKey(loanId);
        }catch (Exception e){
            logger.error("根据id查找贷款申请出错，loanId"+loanId+"error:"+e);
            throw new RuntimeException("根据id查找贷款申请出错!loanId"+loanId);
        }
    }
}
