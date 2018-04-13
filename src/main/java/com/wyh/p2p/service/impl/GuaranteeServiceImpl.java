package com.wyh.p2p.service.impl;

import com.wyh.p2p.generator.entities.P2pGuarantee;
import com.wyh.p2p.generator.entities.P2pGuaranteeExample;
import com.wyh.p2p.generator.mapperInterface.P2pGuaranteeMapper;
import com.wyh.p2p.service.GuaranteeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/9 下午5:33
 **/
@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    private static Logger logger = Logger.getLogger(GuaranteeServiceImpl.class);

    @Autowired
    private P2pGuaranteeMapper p2pGuaranteeMapper;

    public boolean insertSelect(P2pGuarantee p2pGuarantee) {
        try{
        return p2pGuaranteeMapper.insertSelective(p2pGuarantee)>0;
        }catch (Exception e){
            logger.error("insert p2p_guarantee 出错"+"e"+e);
            throw new RuntimeException("insert p2p_guarantee 出错");
        }
    }

    public P2pGuarantee findByCusId(Integer id) {

        P2pGuaranteeExample example = new P2pGuaranteeExample();
        example.createCriteria().andCustomerIdEqualTo(id);
        try{
            List<P2pGuarantee> p2pGraList = p2pGuaranteeMapper.selectByExample(example);
            if (p2pGraList.size()>0) {
                return p2pGraList.get(0);
            }
            return null;
        }catch (Exception e){
            logger.error("find p2p_guarantee by customeId error"+"e:"+e);
            throw new RuntimeException("findByCusId error");
        }
    }

    public boolean updateSelect(P2pGuarantee p2pGuarantee) {
        P2pGuaranteeExample example = new P2pGuaranteeExample();
        example.createCriteria().andCustomerIdEqualTo(p2pGuarantee.getCustomerId());
        try{
            return p2pGuaranteeMapper.updateByExampleSelective(p2pGuarantee,example)>0;
        }catch (Exception e){
            logger.error("update p2p_guarantee by customeId error"+"e:"+e);
            throw new RuntimeException("updateSelect error");
        }

    }

    public boolean checkInfo(Integer id) {
        P2pGuarantee p2pGuarantee;
        P2pGuaranteeExample example = new P2pGuaranteeExample();
        example.createCriteria().andCustomerIdEqualTo(id);
        try{
            List<P2pGuarantee> p2pGraList = p2pGuaranteeMapper.selectByExample(example);
            if (p2pGraList.size()==1) {
                p2pGuarantee = p2pGraList.get(0);
                return check(p2pGuarantee);
            }
            return false;
        }catch (Exception e){
            logger.error("checkInfo p2p_guarantee by customeId error"+"e:"+e);
            throw new RuntimeException("checkInfo error");
        }
    }

    private boolean check(P2pGuarantee p2pGuarantee) {
        if (p2pGuarantee == null){
            return false;
        }
        if (p2pGuarantee.getId() == null || p2pGuarantee.getId() <= 0){
            return false;
        }
        if (p2pGuarantee.getCardFront().equals("")||p2pGuarantee.getCardFront() == null){
            return false;
        }
        if (p2pGuarantee.getCardBack().equals("")||p2pGuarantee.getCardBack() == null){
            return false;
        }
        if (p2pGuarantee.getType() == null || p2pGuarantee.getType() <= 0){
            return false;
        }
        if (p2pGuarantee.getPhotoPath().equals("")||p2pGuarantee.getPhotoPath() == null){
            return false;
        }
        if (p2pGuarantee.getCustomerId() == null || p2pGuarantee.getCustomerId() <= 0){
            return false;
        }
        return true;
    }
}
