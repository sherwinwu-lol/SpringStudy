package com.wusd.framework.aop.adapt;

import com.wusd.framework.aop.advisor.Advisor;
import com.wusd.framework.aop.advisor.AfterRunningAdvice;
import com.wusd.framework.aop.interceptor.AfterRunningAdviceInterceptor;
import com.wusd.framework.aop.interceptor.AopMethodInterceptor;

public class AfterRunningAdviceAdapter implements AdviceAdapter {
    private static final AfterRunningAdviceAdapter INSTANCE = new AfterRunningAdviceAdapter();
    private AfterRunningAdviceAdapter() {

    }
    public static AfterRunningAdviceAdapter getInstance() {
        return INSTANCE;
    }
    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
