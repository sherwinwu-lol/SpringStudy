package com.wusd.design.bridgePattern.old;

/**
 * 抽象类:
 * 用于定义抽象类的接口,它一般是抽象类而不是接口,其中定义了一个Implementor(实现类接口)类型的对象并可以维护该对象,
 * 它与Implementor之间具有关联关系,它既可以包含抽象业务方法,也可以包含具体业务方法.
 */
public abstract class Abstraction {
    //定义实现类接口对象
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    //声明抽象业务方法
    public abstract void operation();
}
