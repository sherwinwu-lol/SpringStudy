package com.wusd.framework.aop.invocation;

import java.lang.reflect.Method;

/**
 * 方法的调用
 */
public interface MethodInvocation {
    //获取方法
    Method getMethod();
    //获取方法传参
    Object[] getArguments();
    //返回方法返回值,执行方法调用本身
    Object proceed() throws Throwable;
}
