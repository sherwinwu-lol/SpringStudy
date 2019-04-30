package com.wusd.design.dynamicProxy;

/**
 * 真实主题角色: 它定义了代理角色所代表的真实对象,在真实主题角色中实现了真实的业务操作,
 * 客户端可以通过代理主题角色间接调用真实主题角色定义的操作.
 */
public class RealSubject extends Subject {
    @Override
    public void request() {

    }
}
