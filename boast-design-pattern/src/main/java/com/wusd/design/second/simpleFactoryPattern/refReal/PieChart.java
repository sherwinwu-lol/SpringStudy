package com.wusd.design.second.simpleFactoryPattern.refReal;

/**
 * 具体产品类
 */
public class PieChart implements Chart {
    public PieChart() {
        System.out.println("create PieChart!");
    }

    public void display() {
        System.out.println("PieChart display!");
    }
}
