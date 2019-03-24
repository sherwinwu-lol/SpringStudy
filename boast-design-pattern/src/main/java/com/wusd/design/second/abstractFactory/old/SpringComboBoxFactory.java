package com.wusd.design.second.abstractFactory.old;

public class SpringComboBoxFactory implements ComboBoxFactory {
    @Override
    public ComboBox getComboBox() {
        return new SpringComboBox();
    }
}
