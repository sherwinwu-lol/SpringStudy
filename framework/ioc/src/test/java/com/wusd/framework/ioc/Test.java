package com.wusd.framework.ioc;

import com.wusd.framework.ioc.entity.Robot;
import com.wusd.framework.ioc.core.JsonApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {

        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");

        aiRobot.show();

    }

}
