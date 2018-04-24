package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pRate;
import com.wyh.p2p.generator.entities.P2pRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pRateMapper {
    int countByExample(P2pRateExample example);

    int deleteByExample(P2pRateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pRate record);

    int insertSelective(P2pRate record);

    List<P2pRate> selectByExample(P2pRateExample example);

    P2pRate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pRate record, @Param("example") P2pRateExample example);

    int updateByExample(@Param("record") P2pRate record, @Param("example") P2pRateExample example);

    int updateByPrimaryKeySelective(P2pRate record);

    int updateByPrimaryKey(P2pRate record);
}