package com.wusd.framework.aop.invocation;

/**
 * 代理要调用的方法
 * 和方法调用一样,多了代理
 */
public interface ProxyMethodInvocation extends MethodInvocation {
    /**
     * 获取代理
     * @return: 获取代理
     */
    Object getProxy();
}
