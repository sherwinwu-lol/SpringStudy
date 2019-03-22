package com.wusd.design.second.simpleFactoryPattern.refReal;

/**
 * 图标工厂
 */
public class ChartFactory {
    /**
     * 静态工厂方法
     */
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("init HistogramChart!");
        }
        else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("init PieChart!");
        }
        else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("init LineChart!");
        }
        return chart;
    }
}
