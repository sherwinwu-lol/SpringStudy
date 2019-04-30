package com.wusd.framework.aop.invocation;

import java.lang.reflect.Method;

/**
 * 执行方法必须调用的接口
 */
public interface MethodInvocation {
    /**
     * 方法本身
     * @return: 方法
     */
    Method getMethod();

    /**
     * 方法的传参
     * @return: 传参数组
     */
    Object[] getArguments();

    /**
     * 方法的执行, 并返回返回值
     * @return: 返回值
     * @throws Throwable
     */
    Object proceed() throws Throwable;
}
