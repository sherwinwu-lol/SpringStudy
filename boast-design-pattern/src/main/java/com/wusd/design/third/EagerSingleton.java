package com.wusd.design.third;

public class EagerSingleton {
    /**
     * 在定义静态变量的时候实例化单例类,因此在类加载的时候就已经创建了单例对象
     */
    private EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {

    }

    public EagerSingleton getInstance() {
        return instance;
    }
}
