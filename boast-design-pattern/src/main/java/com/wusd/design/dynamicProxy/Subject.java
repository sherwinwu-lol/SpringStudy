package com.wusd.design.dynamicProxy;

/**
 * 抽象主题角色: 它声明真实主题和代理主题的共同接口,这样一来在任何使用真实主题的地方都可以使用代理主题,
 * 客户端通常需要针对抽象主题角色进行编程.
 */
public abstract class Subject {

    public abstract void request();
}
