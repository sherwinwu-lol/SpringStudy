package com.wusd.framework.aop.invocation;

import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import com.wusd.framework.aop.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 具体方法的调用
 */
public class ReflectionMethodInvocation implements ProxyMethodInvocation {
    //代理
    protected final Object proxy;
    //被代理
    protected final Object target;
    //被代理的方法
    protected final Method method;
    //被代理方法的传参
    protected Object[] arguments = new Object[0];
    //拦截器列表,作用是执行完拦截器,才会执行真正的方法
    protected final List<AopMethodInterceptor> interceptorList;
    //用于记录拦截器
    private int currentInterceptorIndex = -1;

    public ReflectionMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                      List<AopMethodInterceptor> interceptorList) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptorList = interceptorList;
    }

    //用于保存所有的拦截器,需要递归的去增加拦截器.当处理完了所有拦截器之后,才会真正调用调用被增强的方法.
    @Override
    public Object proceed() throws Throwable {
        //当调用所有的拦截器,执行真正的方法
        if (currentInterceptorIndex == this.interceptorList.size() - 1) {
            return invokeOriginal();
        }

        AopMethodInterceptor interceptor = interceptorList.get(++currentInterceptorIndex);
        //执行拦截器的调用, 拦截器继续调用这个方法, 通过在这个方法前后做些动作实现aop
        return interceptor.invoke(this);
    }

    //方法调用请求真正的方法
    protected Object invokeOriginal() throws Throwable {
        return ReflectionUtils.invokeMethodUseReflection(target, method, arguments);
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
}
