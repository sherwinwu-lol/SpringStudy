package com.wusd.design.third;

/**
 * 该懒汉式单例类在getInstance()方法前面增加了关键字synchronized进行线程锁,
 * 以处理多个线程同时访问的问题. 但是, 上述代码虽然解决了线程安全问题, 但是每次调用
 * getInstance时都需要进行线程锁定判断, 在多线程高并发访问环境中, 将会导致系统性能大大降低.
 * 如何既解决线程安全问题又不影响系统性能呢?
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {

    }

//    synchronized public static LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    /**
     * 改进后
     */
    /**
     * 问题并未解决, 线程A和线程B都在调用getInstance方法, 此时instance对象为null值,
     * 均能通过instance == null的判断.由于实现了synchronized加锁机制,线程A进入synchronized锁定的代码中
     * 执行实例创建代码, 线程B处于排队等待状态, 必须等待线程A执行完毕后才可以进入synchronized锁定代码.
     * 但当A执行完毕时, 线程B并不知道实例已经创建,将继续创建新的实例, 导致产生多个实例对象, 未被单例的
     * 设计模式, 因此需要进行进一步改进, 在synchronized中再进行一次(instance == null)判断,这种方式称为双重检查锁定
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    /**
     * 如果使用双重检查锁定来实现懒汉式单例类, 需要在静态成员变量instance之前加修饰符volatile,
     * 被volatile修饰的成员变量可以确保多个线程都能正确处理. 由于volatile会屏蔽Java虚拟机
     * 所做的一些代码优化, 坑会导致效率降低, 因此即使使用双重检查锁定来实现单例模式也不是一种完美的实现方式.
     * @return
     */
    public static LazySingleton getInstanceB() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    //创建单例实例
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
