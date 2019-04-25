package com.wusd.framework.aop.interceptor;

import com.wusd.framework.aop.advisor.BeforeMethodAdvice;
import com.wusd.framework.aop.invocation.MethodInvocation;

/**
 * 在方法执行以前拦截
 */
public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {
    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //把advice对应的增强方法放在真正执行的方法前面
        advice.before(mi.getMethod(), mi.getArguments(), mi);
        return mi.proceed();
    }
}
