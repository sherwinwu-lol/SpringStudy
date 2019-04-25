package com.wusd.framework.aop.adapt;

import com.wusd.framework.aop.advisor.Advisor;
import com.wusd.framework.aop.interceptor.AopMethodInterceptor;

public interface AdviceAdapter {
    AopMethodInterceptor getInterceptor(Advisor advisor);
}
