package com.wyh.p2p.generator.mapperInterface.ext;

import com.wyh.p2p.entities.pojo.InvestPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyihang
 * @date 2018/4/22 下午2:33
 **/
public interface InvestMapper {

    /**
     * 增加产品已投资金额
     * @param money
     * @param id
     * @return
     */
    int addMoney(@Param("money") double money,@Param("id") int id);

    /**
     * 用户投资列表
     * @param id
     * @return
     */
    List<InvestPojo> investListByUid(@Param("id")int id);

    /**
     * 管理员分页获取投资记录列表
     * @return
     */
    List<InvestPojo> pageList();

}
