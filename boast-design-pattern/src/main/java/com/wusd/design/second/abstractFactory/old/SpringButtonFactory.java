package com.wusd.design.second.abstractFactory.old;

public class SpringButtonFactory implements ButtonFactory {

    @Override
    public Button getButton() {
        return new SpringButton();
    }
}
