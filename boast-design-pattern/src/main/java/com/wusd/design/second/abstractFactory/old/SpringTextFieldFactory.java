package com.wusd.design.second.abstractFactory.old;

public class SpringTextFieldFactory implements TextFildFactory {
    @Override
    public TextField getTextField() {
        return new SpringTextField();
    }
}
