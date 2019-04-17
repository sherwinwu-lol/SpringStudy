package designPattern.monostate;

import junit.framework.TestCase;

public class TestMonostate extends TestCase {
    public TestMonostate(String name) {
        super(name);
    }

    /**
     * 测试可以设置和获取一个对象成员变量x
     */
    public void testInstance() {
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            assertEquals(x, m.getX());
        }
    }

    /**
     * 测试两个实例的表现是一样的
     */
    public void testInstancesBehaveAsOne() {
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();

        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            assertEquals(x, m2.getX());
        }
    }
}
