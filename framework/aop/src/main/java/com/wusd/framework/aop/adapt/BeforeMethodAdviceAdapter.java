package com.wusd.framework.aop.adapt;

import com.wusd.framework.aop.advisor.Advisor;
import com.wusd.framework.aop.advisor.BeforeMethodAdvice;
import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import com.wusd.framework.aop.interceptor.BeforeMethodAdviceInterceptor;

public class BeforeMethodAdviceAdapter implements AdviceAdapter {
    private static final BeforeMethodAdviceAdapter INSTANCE = new BeforeMethodAdviceAdapter();
    private BeforeMethodAdviceAdapter() {

    }
    public static BeforeMethodAdviceAdapter getInstance() {
        return INSTANCE;
    }
    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
