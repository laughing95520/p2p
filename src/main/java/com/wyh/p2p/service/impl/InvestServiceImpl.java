package com.wyh.p2p.service.impl;

import com.wyh.p2p.generator.entities.P2pInvest;
import com.wyh.p2p.generator.mapperInterface.P2pInvestMapper;
import com.wyh.p2p.service.InvestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyihang
 * @date 2018/4/20 下午7:58
 **/
@Service
public class InvestServiceImpl implements InvestService {

    private static Logger logger = Logger.getLogger(InvestServiceImpl.class);


    @Autowired
    private P2pInvestMapper p2pInvestMapper;

    @Override
    public boolean addInvest(P2pInvest p2pInvest) {
        try {
            return p2pInvestMapper.insertSelective(p2pInvest) > 0;
        }catch (Exception e){
            logger.error("addInvest error（p2pInvestMapper）"+e);
            throw new RuntimeException("addInvest error（p2pInvestMapper）");
        }
    }
}
