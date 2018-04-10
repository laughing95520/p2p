package com.wyh.p2p.service;

import com.wyh.p2p.generator.entities.P2pGuarantee; /**
 * @author wangyihang
 * @date 2018/4/9 下午5:33
 **/
public interface GuaranteeService {

    /**
     * 插入担保资料表
     * @param p2pGuarantee
     * @return
     */
    boolean insertSelect(P2pGuarantee p2pGuarantee);

    /**
     * 查找用户的担保资料
     * @return
     */
    P2pGuarantee findByCusId(Integer id);

    /**
     * 更新担保资料
     * @param p2pGuarantee
     * @return
     */
    boolean updateSelect(P2pGuarantee p2pGuarantee);

    /**
     * 检查用户是否完善贷款资料
     * @param id
     * @return
     */
    boolean checkInfo(Integer id);
}
