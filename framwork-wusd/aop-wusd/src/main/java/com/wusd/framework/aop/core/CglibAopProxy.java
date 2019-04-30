package com.wusd.framework.aop.core;

import com.wusd.framework.aop.advisor.AdvisorSupport;
import com.wusd.framework.aop.interceptor.DynamicAdvisorInterceptor;
import com.wusd.framework.ioc.util.ClassUtils;
import lombok.Data;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

@Data
public class CglibAopProxy implements AopProxy {
    private AdvisorSupport advisor;
    private Object[] constructArgs;
    private Class<?>[] constructArgTypes;
    public CglibAopProxy(AdvisorSupport config) {
        this.advisor = config;
    }
    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        Class<?> rootClass = advisor.getTargetSource().getTargetClass();
        if (classLoader == null) {
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());
        Callback callback = getCallback(advisor);
        enhancer.setCallback(callback);
        enhancer.setClassLoader(classLoader);
        if (constructArgs != null && constructArgs.length > 0) {
            return enhancer.create(constructArgTypes, constructArgs);
        }
        return enhancer.create();
    }
    private Callback getCallback(AdvisorSupport advisor) {
        return new DynamicAdvisorInterceptor(advisor.getList(), advisor.getTargetSource());
    }
}
