package com.wusd.design.second.factoryMethod.relFinal;

public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("DatabaseLogger.writeLog");
    }
}
