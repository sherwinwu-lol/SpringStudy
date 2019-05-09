package com.wusd.design.compositeMode.refReal;

/**
 * 抽象文件类:
 * 抽象构件
 */
abstract public class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
