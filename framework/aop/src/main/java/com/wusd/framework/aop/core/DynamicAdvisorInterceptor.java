package com.wusd.framework.aop.core;

import com.wusd.framework.aop.advisor.TargetSource;
import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import com.wusd.framework.aop.invocation.CglibMethodInvocation;
import com.wusd.framework.aop.invocation.MethodInvocation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 这个类实现的MethodInterceptor是cglib的接口, 并非我们之前AopMethodInterceptor
 */
public class DynamicAdvisorInterceptor implements MethodInterceptor {
    protected final List<AopMethodInterceptor> interceptorList;
    protected final TargetSource targetSource;

    public DynamicAdvisorInterceptor(List<AopMethodInterceptor> interceptorList, TargetSource targetSource) {
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        /**
         * 通过这行代码,我们的整个逻辑终于连起来了.
         * 也就是这个动态的拦截器,把我们通过CglibMethodInvocation织入了增强代码的方法,委托给了cglib来生成代理对象.
         * 至此我们的Aop核心功能就实现了
         */
        MethodInvocation invocation = new CglibMethodInvocation(obj, targetSource.getTargetObject(), method,
                args, interceptorList, proxy);
        return invocation.proceed();
    }
}
