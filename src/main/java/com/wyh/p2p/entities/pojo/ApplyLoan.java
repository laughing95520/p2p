package com.wyh.p2p.entities.pojo;

import com.wyh.p2p.generator.entities.P2pLoan;

/**
 * @author wangyihang
 * @date 2018/4/9 上午10:50
 **/
public class ApplyLoan extends P2pLoan{

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
