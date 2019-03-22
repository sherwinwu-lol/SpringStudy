package com.wusd.design.second.simpleFactoryPattern.refReal;

/**
 * 柱状图类:具体产品类
 */
public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("creat HistogramChart!");
    }

    @Override
    public void display() {
        System.out.println("HistogramChart display!");
    }
}
