package com.wusd.design.second.factoryMethod.relFinal;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
