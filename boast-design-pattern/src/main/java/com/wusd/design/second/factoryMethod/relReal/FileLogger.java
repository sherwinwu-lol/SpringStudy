package com.wusd.design.second.factoryMethod.relReal;

public class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("FileLogger.writeLog");
    }
}
