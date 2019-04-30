package com.wusd.framework.aop.interceptor;

import com.wusd.framework.aop.advisor.BeforeMethodAdvice;
import com.wusd.framework.aop.invocation.MethodInvocation;

/**
 * 具体拦截器:方法执行前
 */
public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {
    //用来保存方法执行干了什么
    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //先调用 切面方法
        advice.before(mi.getMethod(), mi.getArguments(), mi);
        //再调用 实际方法
        return mi.proceed();
    }
}
