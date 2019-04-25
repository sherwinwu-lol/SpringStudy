package com.wusd.framework.aop.invocation;

/**
 * 代理方法的调用
 */
public interface ProxyMethodInvocation extends MethodInvocation {
    /**
     * 获取代理的方法
     * @return
     */
    Object getProxy();
}
