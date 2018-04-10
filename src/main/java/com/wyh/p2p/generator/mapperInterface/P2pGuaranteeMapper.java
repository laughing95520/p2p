package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pGuarantee;
import com.wyh.p2p.generator.entities.P2pGuaranteeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pGuaranteeMapper {
    int countByExample(P2pGuaranteeExample example);

    int deleteByExample(P2pGuaranteeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pGuarantee record);

    int insertSelective(P2pGuarantee record);

    List<P2pGuarantee> selectByExample(P2pGuaranteeExample example);

    P2pGuarantee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pGuarantee record, @Param("example") P2pGuaranteeExample example);

    int updateByExample(@Param("record") P2pGuarantee record, @Param("example") P2pGuaranteeExample example);

    int updateByPrimaryKeySelective(P2pGuarantee record);

    int updateByPrimaryKey(P2pGuarantee record);
}