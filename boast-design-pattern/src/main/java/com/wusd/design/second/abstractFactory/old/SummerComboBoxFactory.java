package com.wusd.design.second.abstractFactory.old;

public class SummerComboBoxFactory implements ComboBoxFactory {
    @Override
    public ComboBox getComboBox() {
        return new SummerComboBox();
    }
}
