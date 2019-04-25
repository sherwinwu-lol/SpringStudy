package com.wusd.framework.aop.advisor;

import java.lang.reflect.Method;

public interface BeforeMethodAdvice extends Advice {
    void before(Method method, Object[] args, Object target);
}
