package com.wusd.framework.aop.interceptor;

import com.wusd.framework.aop.advisor.AfterRunningAdvice;
import com.wusd.framework.aop.invocation.MethodInvocation;

/**
 * 方法运行结束以后拦截
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {
    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        //把advice对应的增加方法放在真正执行的方法后面
        advice.after(returnVal, mi.getMethod(), mi.getArguments(), mi);
        return returnVal;
    }
}
