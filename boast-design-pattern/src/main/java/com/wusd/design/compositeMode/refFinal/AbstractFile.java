package com.wusd.design.compositeMode.refFinal;

abstract public class AbstractFile {
    public void add(AbstractFile file) {
        System.out.println("对不起,不支持该方法!");
    }

    public void remove(AbstractFile file) {
        System.out.println("对不起,不支持该方法!");
    }

    public AbstractFile getChild(int i) {
        System.out.println("对不起,不支持该方法!");
        return null;
    }

    abstract public void killVirus();
}
