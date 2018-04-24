package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pRepayment;
import com.wyh.p2p.generator.entities.P2pRepaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pRepaymentMapper {
    int countByExample(P2pRepaymentExample example);

    int deleteByExample(P2pRepaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pRepayment record);

    int insertSelective(P2pRepayment record);

    List<P2pRepayment> selectByExample(P2pRepaymentExample example);

    P2pRepayment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pRepayment record, @Param("example") P2pRepaymentExample example);

    int updateByExample(@Param("record") P2pRepayment record, @Param("example") P2pRepaymentExample example);

    int updateByPrimaryKeySelective(P2pRepayment record);

    int updateByPrimaryKey(P2pRepayment record);
}