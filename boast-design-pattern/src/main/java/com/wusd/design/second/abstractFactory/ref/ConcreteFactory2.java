package com.wusd.design.second.abstractFactory.ref;

public class ConcreteFactory2 implements Factory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}
