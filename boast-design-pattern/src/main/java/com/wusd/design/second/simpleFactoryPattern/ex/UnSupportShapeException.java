package com.wusd.design.second.simpleFactoryPattern.ex;


public class UnSupportShapeException extends Exception {
    public UnSupportShapeException(String errorMsg) {
        System.err.println(errorMsg + " was not support shape!");
    }
}
