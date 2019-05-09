package com.wusd.design.compositeMode.ref;

abstract public class Component {
    //增加成员
    public abstract void add(Component c);
    //删除成员
    public abstract void remove(Component c);
    //获取成员
    public abstract Component getChild(int i);
    //业务方法
    public abstract void operation();
}
