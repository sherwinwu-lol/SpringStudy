package com.wusd.framework.aop.core;

import com.wusd.framework.aop.advisor.AdvisorSupport;
import com.wusd.framework.ioc.utils.ClassUtils;
import lombok.Data;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

@Data
public class CglibAopProxy implements AopProxy {
    private AdvisorSupport advisor;
    private Object[] constructorArgs;
    private Class<?>[] constructorArgTypes;
    public CglibAopProxy(AdvisorSupport config) {
        this.advisor = config;
    }

    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        //获取真正对象的Class
        Class<?> rootClass = advisor.getTargetSource().getTargetClass();
        if (classLoader == null) {
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());
        //增加拦截器的核心方法
        Callback callback = getCallBack(advisor);
        enhancer.setCallback(callback);

        enhancer.setClassLoader(classLoader);
        if (constructorArgs != null && constructorArgs.length > 0) {
            return enhancer.create(constructorArgTypes, constructorArgs);
        }
        return enhancer.create();
    }

    private Callback getCallBack(AdvisorSupport advisor) {
        return new DynamicAdvisorInterceptor(advisor.getList(), advisor.getTargetSource());
    }
}
