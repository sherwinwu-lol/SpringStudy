package com.wusd.design.second.abstractFactory.old;

public class SummerTextFieldFactory implements TextFildFactory {
    @Override
    public TextField getTextField() {
        return new SummerTextField();
    }
}
