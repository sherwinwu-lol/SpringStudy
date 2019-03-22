package com.wusd.design.second.simpleFactoryPattern.ex;

public class Circle implements Graph {
    public void erase() {
        System.out.println("Circle erase");
    }

    public void draw() {
        System.out.println("Circle draw");
    }
}
