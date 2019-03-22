package com.wusd.design.second.simpleFactoryPattern.ex;

public class Rectangle implements Graph {
    public void erase() {
        System.out.println("Rectangle.erase");
    }

    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
