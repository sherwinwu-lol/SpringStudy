package com.wusd.design.second.factoryMethod.relFinal;

public class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        factory = new DatabaseLoggerFactory();
        logger = factory.createLogger();
        logger.writeLog();
    }
}
