package com.wusd.design.second.factoryMethod.relReal;

public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("DatabaseLogger.writeLog");
    }
}
