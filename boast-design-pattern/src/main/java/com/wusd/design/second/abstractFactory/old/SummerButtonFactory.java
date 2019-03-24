package com.wusd.design.second.abstractFactory.old;

public class SummerButtonFactory implements ButtonFactory {
    @Override
    public Button getButton() {
        return new SummerButton();
    }
}
