package com.wusd.design.second.simpleFactoryPattern.ref;

/**
 * 客户端,通过工厂类的工厂方法可得到产品对象
 */
public class Client {
    public static void main(String[] args) {
        Product product;
        //通过工厂类创建产品对象
        product = Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
    }
}
