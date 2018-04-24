package com.wyh.p2p.generator.mapperInterface.ext;

import org.apache.ibatis.annotations.Param;

/**
 * @author wangyihang
 * @date 2018/4/22 下午2:33
 **/
public interface InvestMapper {

    int addMoney(@Param("money") double money,@Param("id") int id);
}
