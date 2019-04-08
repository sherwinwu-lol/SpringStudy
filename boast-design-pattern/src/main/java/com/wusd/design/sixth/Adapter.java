package com.wusd.design.sixth;

/**
 * 适配器类: 适配器调用另一个接口,作为一个转换器,对Adaptee
 */
public class Adapter extends Target {
    @Override
    public void request() {
        Adaptee adaptee = new Adaptee();
        adaptee.specificRequest();
    }
}