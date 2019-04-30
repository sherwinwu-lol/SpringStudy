package com.wusd.framework.aop.interceptor;

import com.wusd.framework.aop.invocation.MethodInvocation;

/**
 * aop方法的拦截器
 */
public interface AopMethodInterceptor {
    //执行拦截的调用
    Object invoke(MethodInvocation mi) throws Throwable;
}
