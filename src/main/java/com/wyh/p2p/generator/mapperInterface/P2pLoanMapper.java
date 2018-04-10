package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.P2pLoan;
import com.wyh.p2p.generator.entities.P2pLoanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2pLoanMapper {
    int countByExample(P2pLoanExample example);

    int deleteByExample(P2pLoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(P2pLoan record);

    int insertSelective(P2pLoan record);

    List<P2pLoan> selectByExample(P2pLoanExample example);

    P2pLoan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P2pLoan record, @Param("example") P2pLoanExample example);

    int updateByExample(@Param("record") P2pLoan record, @Param("example") P2pLoanExample example);

    int updateByPrimaryKeySelective(P2pLoan record);

    int updateByPrimaryKey(P2pLoan record);
}