package com.wusd.design.second.simpleFactoryPattern.refReal;

import com.wusd.design.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
//        Chart chart;
//        chart = ChartFactory.getChart("histogram");
//        chart.display();
//        chart = ChartFactory.getChart("pie");
//        chart.display();
        Chart chart;
        //读取配置文件
        String type = XMLUtil.getRootTag("target/classes/config.xml", "chartType");
        chart = ChartFactory.getChart(type);
        chart.display();
    }
}
