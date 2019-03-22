package com.wusd.design.second.factoryMethod.ref;

public class ConcreteFactory {
    Product getProduct() {
        return new ConcreteProduct();
    }
}
