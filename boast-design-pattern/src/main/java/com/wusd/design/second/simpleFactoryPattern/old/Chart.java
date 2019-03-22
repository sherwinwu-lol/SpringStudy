package com.wusd.design.second.simpleFactoryPattern.old;

public class Chart {
    //图标类型
    private String type;

    public Chart(Object[][] data, String type) {
        this.type = type;
        if (type.equalsIgnoreCase("histogram")) {
            //初始化柱形图
        }
        else if (type.equalsIgnoreCase("pie")) {
            //初始化饼状图
        }
        else if (type.equalsIgnoreCase("line")) {
            //初始化折线图
        }
    }

    public void display() {
        if (this.type.equalsIgnoreCase("histogram")) {
            //显示饼状图
        }
        else if (this.type.equalsIgnoreCase("pie")) {
            //显示饼状图
        }
        else if (this.type.equalsIgnoreCase("line")) {
            //显示折线图
        }
    }
}
