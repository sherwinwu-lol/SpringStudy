package designPattern.monostate;

/**
 * 所有的对象共享相同的变量,所有的变量都是静态变量
 * itsX是静态的, 而且所有的方法都不是静态的.
 */
public class Monostate {
    private static int itsX = 0;
    public Monostate() {}

    public void setX(int x) {
        itsX = x;
    }

    public int getX() {
        return itsX;
    }
}
/**
 * 好处:
 * 透明性: 使用Monostate对象和常规没区别,使用者不需要知道对象是monostate
 * 可派生性: monostate的子类都共享相同的静态变量
 * 多态性: monostate的方法不是静态的, 因此, 不同的派生类可以基于同样的静态变量表现不同的行为
 *
 * 代价:
 * 不可转换性: 不能透过子类把常规类转换成MONOSTATE类
 * 效率问题: monostate是真正的对象,所以会导致许多的创建和销毁开销
 * 内存占用: 即使从未使用monostate, 它的变量也要占据内存空间
 * 平台局限性: monostate不能跨多个jvm或者多个平台工作
 */
