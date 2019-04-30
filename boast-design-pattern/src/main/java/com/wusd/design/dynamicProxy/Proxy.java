package com.wusd.design.dynamicProxy;

/**
 * 代理主题角色: 包含了对真实主题引用,从而可以在任何时候操作真实主题对象;
 * 在代理主题角色中提供一个与真实主题角色相同的接口,以便在任何时候都可以替代真实主题对象;
 * 并对真实主题对象的使用加以约束.通常,在代理主题角色中,客户端在调用所引用的真实主题操作之前或之后还需要执行其他操作,
 * 而不仅仅是单纯调用真实主题对象中的操作.
 */
public class Proxy extends Subject {
    private RealSubject realSubject = new RealSubject();
    public void preRequest() {

    }
    public void postRequest() {

    }
    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }
}
