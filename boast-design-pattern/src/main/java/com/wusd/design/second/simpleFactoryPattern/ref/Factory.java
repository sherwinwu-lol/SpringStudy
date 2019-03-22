package com.wusd.design.second.simpleFactoryPattern.ref;

/**
 * 简单工厂模式的核心,使用工厂类来创建产品
 */
public class Factory {
    /**
     * 静态工厂方法
     */
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            //初始化设置product
            product = new ConcreteProductA();
        }
        else if (arg.equalsIgnoreCase("B")) {
            //初始化设置product
            product = new ConcreteProductA();
        }
        return product;
    }
}
