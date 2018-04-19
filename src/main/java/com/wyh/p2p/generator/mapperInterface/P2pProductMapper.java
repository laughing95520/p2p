package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pProduct;
import com.wyh.p2p.generator.entities.P2pProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pProductMapper {
    int countByExample(P2pProductExample example);

    int deleteByExample(P2pProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pProduct record);

    int insertSelective(P2pProduct record);

    List<P2pProduct> selectByExample(P2pProductExample example);

    P2pProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pProduct record, @Param("example") P2pProductExample example);

    int updateByExample(@Param("record") P2pProduct record, @Param("example") P2pProductExample example);

    int updateByPrimaryKeySelective(P2pProduct record);

    int updateByPrimaryKey(P2pProduct record);
}