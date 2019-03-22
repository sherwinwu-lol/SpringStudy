package com.wusd.design.second.factoryMethod.relReal;

public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
