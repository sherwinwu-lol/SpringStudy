package com.wusd.framework.aop.interceptor;

import com.wusd.framework.aop.invocation.MethodInvocation;

/**
 * 是Aop容器所有拦截器都要实现的接口
 */
public interface AopMethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
