package com.wusd.framework.aop.invocation;

import com.wusd.framework.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class CglibMethodInvocation extends ReflectionMethodInvocation {
    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                 List<AopMethodInterceptor> interceptorList, MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    //使用cglib方法代理类来请求方法的调用, 是增强, 实际逻辑是一样的
    @Override
    protected Object invokeOriginal() throws Throwable {
        return methodProxy.invoke(target, arguments);
    }
}
