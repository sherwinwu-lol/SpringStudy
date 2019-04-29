package com.wusd.framework.ioc;

import com.wusd.framework.ioc.core.JsonApplicationContext;
import com.wusd.framework.ioc.entity.Robot;

public class Main {
    public static void main(String[] args) throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");
        aiRobot.show();
    }
}
