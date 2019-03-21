package com.wusd.design.first.openClose;

public class ChartDisplay {
    AbstractChart chart;
    void setChart(AbstractChart chart) {
        this.chart = chart;
    }
    void display() {
        chart.display();
    }
//    public void display(String type) {
//        if (type.equals("pie")) {
//            PieChart chart = new PieChart();
//            chart.display();
//        }
//        else if (type.equals("bar")) {
//            BarChart chart = new BarChart();
//            chart.display();
//        }
//    }
}
