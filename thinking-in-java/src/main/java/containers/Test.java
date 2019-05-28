package containers;

public abstract class Test<C> {
    String name;
    public Test(String name) {
        this.name = name;
    }
    //Override this method for different tests.
    //Returns actual number of repetitions of test.
    abstract int test(C container, TestParam tp);
}
/**
 * 每个Test对象都存储了该测试的名字,当你调用test()方法时,必须给出待测容器,以及"信使"或"数据传输对象",
 * 它们保存有用于该特定测试的各种参数.这些参数包括size,它表示在容器中的元素数量;以及loops,它用来控制该
 * 测试迭代的次数.这些参数在每个测试中都有可能会用到,也有可能会用不到.
 * 每个容器都要经历一系列对test()的调用,每个都带有不同的TestParam,因此TestParam还包含静态的array()方
 * 法,使得创建TestParam对象数组变得更容易.array()的第一个版本接收的是可变参数列表,其中包括可互换的size
 * 和loops的值;而第二个版本接收相同类型的列表,但是它的值都在String中---通过这种方式,它可以用来解析命令
 * 行参数:
 */
