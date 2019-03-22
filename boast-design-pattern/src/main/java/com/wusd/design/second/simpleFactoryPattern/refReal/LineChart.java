package com.wusd.design.second.simpleFactoryPattern.refReal;

/**
 * 折线图类
 */
public class LineChart implements Chart {
    public LineChart() {
        System.out.println("create LineChart!");
    }

    public void display() {
        System.out.println("LineChart display!");
    }
}
