package singleton;

public class Singleton {
    private static Singleton theInstance = null;

    /**
     * 不使用instance方法就无法创建它的实例
     */
    private Singleton() {}

    /**
     * 外部访问实例接口
     * @return
     */
    public static Singleton instance() {
        if (theInstance == null) {
            theInstance = new Singleton();
        }
        return theInstance;
    }
}
/**
 * 跨平台: 使用合适的中间件, 可以把SINGLETON模式扩展为跨多个JVM和多个计算机工作
 * 适用于任务类:
 * 可以通过派生创建:给定一个类, 可以创建它的一个SINGLETON子类
 * 延迟求值:如果singleton从未使用过,就决不会创建它
 *
 * 代价:
 * 摧毁方法未定义: 没有好的方法去摧毁一个SINGLETON,可能会存在两个实例
 * 不能继承: 子类不是SINGLETON
 * 效率问题:每次调用instance方法都会执行if语句,就大多数调用,if语句是多余的
 * 不透明性:SINGLETON的使用者知道它们正在使用一个SINGLETON, 因为它们必须要调用instance方法
 */
