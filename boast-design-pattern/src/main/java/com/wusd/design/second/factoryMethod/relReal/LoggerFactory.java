package com.wusd.design.second.factoryMethod.relReal;

public abstract class LoggerFactory {
    public abstract Logger createLogger();

    public void writeLog() {
        Logger logger = this::createLogger;
        logger.writeLog();
    }
}
