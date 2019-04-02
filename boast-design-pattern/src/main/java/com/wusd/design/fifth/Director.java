package com.wusd.design.fifth;

/**
 * 1.隔离客户与创建过程
 * 2.控制产品的创建过程, 多个buildPartX()方法调用的先后次序.
 */
//指挥者类
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder){
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
