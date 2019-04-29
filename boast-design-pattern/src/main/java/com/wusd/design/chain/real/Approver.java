package com.wusd.design.chain.real;

import lombok.Setter;

/**
 * 审批者类:抽象处理者
 */
@Setter
public abstract class Approver {
    //定义后继对象
    protected Approver successor;
    //审批者姓名
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);
}
