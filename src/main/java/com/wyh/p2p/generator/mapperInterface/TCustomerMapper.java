package com.wyh.p2p.generator.mapperInterface;

import com.wyh.p2p.generator.entities.TCustomer;
import com.wyh.p2p.generator.entities.TCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCustomerMapper {
    int countByExample(TCustomerExample example);

    int deleteByExample(TCustomerExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    List<TCustomer> selectByExample(TCustomerExample example);

    TCustomer selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    int updateByExample(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);
}