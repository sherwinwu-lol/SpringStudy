package com.wusd.framework.aop.core;

import com.wusd.framework.aop.adapt.AfterRunningAdviceAdapter;
import com.wusd.framework.aop.adapt.BeforeMethodAdviceAdapter;
import com.wusd.framework.aop.advisor.*;
import com.wusd.framework.aop.bean.AopBeanDefinition;
import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import com.wusd.framework.ioc.core.BeanFactoryImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AopBeanFactoryImpl extends BeanFactoryImpl {
    private static final ConcurrentHashMap<String, AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Object> aopBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        Object aopBean = aopBeanMap.get(name);

        if (aopBean != null) {
            return aopBean;
        }

        if (aopBeanDefinitionMap.containsKey(name)) {
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            AdvisorSupport advisorSupport = getAdvisedSupport(aopBeanDefinition);
            aopBean = new CglibAopProxy(advisorSupport).getProxy();
            aopBeanMap.put(name, aopBean);
            return aopBean;
        }
        return super.getBean(name);
    }

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition) {
        aopBeanDefinitionMap.put(name, aopBeanDefinition);
    }

    private AdvisorSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {
        AdvisorSupport advisorSupport = new AdvisorSupport();
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if (interceptorNames != null && !interceptorNames.isEmpty()) {
            for (String interceptorName : interceptorNames) {
                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if (advice instanceof BeforeMethodAdvice) {
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisorSupport.addAopMethodInterceptor(interceptor);
                }

                if (advice instanceof AfterRunningAdvice) {
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisorSupport.addAopMethodInterceptor(interceptor);
                }
            }
        }

        TargetSource targetSource = new TargetSource();

        Object object = getBean(aopBeanDefinition.getTarget());

        targetSource.setTargetClass(object.getClass());

        targetSource.setTargetObject(object);

        advisorSupport.setTargetSource(targetSource);

        return advisorSupport;
    }
}
