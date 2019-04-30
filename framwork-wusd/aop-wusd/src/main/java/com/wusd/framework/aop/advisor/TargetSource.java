package com.wusd.framework.aop.advisor;

import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class TargetSource {
    private Class<?> targetClass;
    private Object targetObject;
    private List<AopMethodInterceptor> aopMethodInterceptors = new LinkedList<>();
    public void addAopMethodInterceptor(AopMethodInterceptor interceptor) {
        aopMethodInterceptors.add(interceptor);
    }

    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors) {
        aopMethodInterceptors.addAll(interceptors);
    }
}
