package com.wusd.design.second.factoryMethod.relReal;

import com.wusd.design.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        factory = (LoggerFactory) XMLUtil.getBean();
        factory.writeLog();
    }
}
