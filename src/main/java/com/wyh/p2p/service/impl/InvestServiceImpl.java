package com.wyh.p2p.service.impl;

import com.github.pagehelper.PageHelper;
import com.wyh.p2p.entities.pojo.InvestPojo;
import com.wyh.p2p.generator.entities.P2pInvest;
import com.wyh.p2p.generator.mapperInterface.P2pInvestMapper;
import com.wyh.p2p.generator.mapperInterface.ext.InvestMapper;
import com.wyh.p2p.service.InvestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/20 下午7:58
 **/
@Service
public class InvestServiceImpl implements InvestService {

    private static Logger logger = Logger.getLogger(InvestServiceImpl.class);


    @Autowired
    private P2pInvestMapper p2pInvestMapper;

    @Autowired
    private InvestMapper myInvestMapper;

    @Override
    public boolean addInvest(P2pInvest p2pInvest) {
        try {
            return p2pInvestMapper.insertSelective(p2pInvest) > 0;
        }catch (Exception e){
            logger.error("addInvest error（p2pInvestMapper）"+e);
            throw new RuntimeException("addInvest error（p2pInvestMapper）");
        }
    }

    @Override
    public List<InvestPojo> getList(Integer id) {
        try{
            return myInvestMapper.investListByUid(id);
        }catch (Exception e){
            logger.error("用户投资记录列表出错！id:"+id+"error:"+e);
            throw new RuntimeException("用户投资记录列表出错！id:"+id);
        }
    }

    @Override
    public List<InvestPojo> pageList(int page, int rows) {
        try{
            PageHelper.startPage(page,rows);
            return myInvestMapper.pageList();
        }catch (Exception e){
            logger.error("管理员分页获取用户投资记录出错！error:"+e);
            throw new RuntimeException("管理员分页获取用户投资记录出错");
        }
    }

    @Override
    public P2pInvest getByIid(int id) {
        try{
            return p2pInvestMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            logger.error("获得投资记录失败！id"+id+"error:"+e);
            throw new RuntimeException("获得投资记录失败！id"+id);
        }
    }

    @Override
    public boolean changeState(int iid) {
        try{
            P2pInvest p2pInvest = new P2pInvest();
            p2pInvest.setIid(iid);
            p2pInvest.setState((byte) 1);
            return p2pInvestMapper.updateByPrimaryKeySelective(p2pInvest) > 0;
        }catch (Exception e){
            logger.error("更改投资记录状态出错！iid:"+iid+"error:"+e);
            throw new RuntimeException("更改投资记录状态出错！iid"+iid);
        }
    }
}
