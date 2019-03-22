package com.wusd.design.second.simpleFactoryPattern.ref;

/**
 * 首先对产品进行重构,声明一些抽象方法,以供不同的具体产品类来实现
 */
public abstract class Product {
    //所有产品类的公共业务方法
    public void methodSame() {
        //公共方法的实现
    }

    //声明抽象业务方法
    public abstract void methodDiff();
}
