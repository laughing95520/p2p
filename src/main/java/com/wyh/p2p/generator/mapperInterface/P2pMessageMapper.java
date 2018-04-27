package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pMessage;
import com.wyh.p2p.generator.entities.P2pMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pMessageMapper {
    int countByExample(P2pMessageExample example);

    int deleteByExample(P2pMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pMessage record);

    int insertSelective(P2pMessage record);

    List<P2pMessage> selectByExample(P2pMessageExample example);

    P2pMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pMessage record, @Param("example") P2pMessageExample example);

    int updateByExample(@Param("record") P2pMessage record, @Param("example") P2pMessageExample example);

    int updateByPrimaryKeySelective(P2pMessage record);

    int updateByPrimaryKey(P2pMessage record);
}