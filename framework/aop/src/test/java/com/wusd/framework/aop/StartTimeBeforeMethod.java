package com.wusd.framework.aop;

import com.wusd.framework.aop.advisor.BeforeMethodAdvice;
import com.wusd.framework.aop.util.ThreadLocalUtils;

import java.lang.reflect.Method;

public class StartTimeBeforeMethod implements BeforeMethodAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");
        ThreadLocalUtils.set(startTime);
    }
}
