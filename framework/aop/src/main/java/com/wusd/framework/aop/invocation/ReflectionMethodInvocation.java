package com.wusd.framework.aop.invocation;

import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import com.wusd.framework.aop.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

public class ReflectionMethodInvocation implements ProxyMethodInvocation {
    protected final Object proxy;
    protected final Object target;
    protected final Method method;
    protected Object[] arguments = new Object[0];
    //用于保存所有的拦截器,需要递归的去增加拦截器.当处理完了所有拦截器之后,才会真正调用调用被增强的方法.
    protected final List<AopMethodInterceptor> interceptorList;
    private int currentInterceptorIndex = -1;

    public ReflectionMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                      List<AopMethodInterceptor> interceptorList) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptorList = interceptorList;
    }

    @Override
    public Object getProxy() {
        return proxy;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    //用于保存所有的拦截器,需要递归的去增加拦截器.当处理完了所有拦截器之后,才会真正调用调用被增强的方法.
    @Override
    public Object proceed() throws Throwable {
        //执行完所有的拦截器后,执行目标方法
        if (currentInterceptorIndex == this.interceptorList.size() - 1) {
            return invokeOriginal();
        }

        //迭代的执行拦截器.回顾上面的讲解,我们实现的拦截都会执行mi.proceed() 实际上又会调用这个方法.
        //实现了一个递归的调用,直到执行完所有的拦截器.
        AopMethodInterceptor interceptor = interceptorList.get(++currentInterceptorIndex);
        return interceptor.invoke(this);
    }

    protected Object invokeOriginal() throws Throwable {
        return ReflectionUtils.invokeMethodUseReflection(target, method, arguments);
    }
}
