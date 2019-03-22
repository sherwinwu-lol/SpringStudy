package com.wusd.design.second.factoryMethod.old;

public class LoggerFactory {
    Logger createLogger(String args) {
        Logger logger = null;
        switch (args) {
            case "fileLogger": logger = new FileLogger();
            break;
            case "databaseLogger": logger = new DatabaseLogger();
        }
        return logger;
    }
}
