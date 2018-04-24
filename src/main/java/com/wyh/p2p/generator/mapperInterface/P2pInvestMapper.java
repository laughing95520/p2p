package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pInvest;
import com.wyh.p2p.generator.entities.P2pInvestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pInvestMapper {
    int countByExample(P2pInvestExample example);

    int deleteByExample(P2pInvestExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(P2pInvest record);

    int insertSelective(P2pInvest record);

    List<P2pInvest> selectByExample(P2pInvestExample example);

    P2pInvest selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") P2pInvest record, @Param("example") P2pInvestExample example);

    int updateByExample(@Param("record") P2pInvest record, @Param("example") P2pInvestExample example);

    int updateByPrimaryKeySelective(P2pInvest record);

    int updateByPrimaryKey(P2pInvest record);
}