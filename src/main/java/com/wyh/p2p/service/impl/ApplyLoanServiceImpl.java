package com.wyh.p2p.service.impl;

import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pLoanExample;
import com.wyh.p2p.generator.mapperInterface.P2pLoanMapper;
import com.wyh.p2p.service.ApplyLoanService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public boolean insertApply(P2pLoan p2pLoan) {
        try {
            return p2pLoanMapper.insertSelective(p2pLoan)>0;
        }catch (Exception e){
            logger.error("insert p2pLoan error"+e);
            return false;
        }
    }

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
}
