package com.wusd.design.third;

/**
 * 饿汉式单例类不能实现延迟加载, 不管将来用不用始终占据内存;
 * 懒汉式单例类线程安全控制烦琐, 而且性能受影响.
 * 可见, 无论是饿汉式单例还是懒汉式单例都存在这样那样的问题
 * Initialization Demand Holder
 */
public class Singleton {
    private Singleton() {

    }

    private static class HoldClass {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return HoldClass.instance;
    }

    public static void main(String[] args) {
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
/**
 * 编译并运行上述代码, 结果为true.
 * 由于静态单例对象没有作为Singleton的成员变量直接实例化, 因此类加载时不会实例化Singleton,
 * 第一次调用getInstance时将加载内部类HolderClass, 在该内部类中定义了一个static类型的变量
 * instance, 此时会首先初始化这个成员变量, 由Java虚拟机来保证线程安全性, 确保该成员变量只能初始化一次.
 * 由于getInstance方法没有任何线程锁定, 因此其性能不会造成任何影响.
 *
 * 通过使用IoDH, 我们既可以实现延迟加载, 又可以保证线程安全, 不影响系统性能, 不失为一种最好的Java语音单例模式实现方法.
 */
