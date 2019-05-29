package containers;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.*;

public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), 47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            int test(List<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, 47);//Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5)
                        list.remove(5);//Minimize random-access cost
                }
                return loops * size;
            }
        });
        //Tests for queue behavior:
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++)  {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }
        //Fill to the appropriate size before each test:
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        //Convenience method:
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        //Can only do these two tests on an array:
        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)) {
            //This will be called before each test. It produces a non-resizeable array-backed list:
            protected List<Integer> initialize(int size) {
                Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}
/**
 * 每个测试都需要仔细地思考,以确保可以产生有意义的结果.例如,add测试首先清除List,然后重新填充它到指定的列表尺寸.
 * 因此,对clear()的调用也就成了该测试的一部分,并且可能会对执行时间产生影响,尤其是对小型的测试.尽管这里的结果看
 * 起来相当合理,但是你可以设想重写测试框架,使得在计时循环之外有一个对准备方法的调用(在本例中包括clear()调用).
 * 注意,对于每个测试,你都必须准确地计算将要发生的操作的数量以及从test()种返回的值,因此计时是正确的.
 * get和set测试都使用了随机数生成器来执行对List的随机访问.在输出中,你可以看到,对于背后由数组支撑的List和ArrayList,
 * 无论列表的大小如何,这些访问都很快速和一致;而对于LinkedList,访问时间对于较大的列表将明显增加.很显然,如果你需要
 * 执行大量的随机访问,链接链接不会是一种好的选择.
 * iteradd测试使用迭代器在列表中间插入新的元素.对于ArrayList,当列表变大时,其开销将变得很高昂,但是对于LinkedList,
 * 相对来说比较低廉,并且不随列表尺寸而发生变化.这是ArrayList在插入时,必须创建空间并将它的所有引用向前移动,这会随
 * ArrayList的尺寸增加而产生高昂的代价.LinkedList只需链接新的元素,而不必修改列表中剩余的元素,因此你可以认为无论
 * 列表尺寸如何变化,其代价大致相同.
 * insert和remove测试都使用了索引位置5作为插入或移除点,而么有选择List两端的元素.LinkedList对List的端点会进行特殊
 * 处理---这使得在LinkedList作为Queue时,速度可以得到提高.但是,如果你在列表的中间增加或移除元素,其中会包含随机访问
 * 的代价,我们已经看到了,这在不同的List实现中变化很大.当执行在位置5的插入和移除时,随机访问的代价应该可以被忽略,但
 * 是我们将看不到对LinkedList端点所做的任何特殊优化操作.从输出中可以看到,在LinkedList中的插入和移除代价相当低廉,
 * 并且不随列表尺寸发生变化,但是对于ArrayList,插入操作代价特别高昂,并且其代价将随列表尺寸的增加而增加.
 * 从Queue测试中,你可以看到LinkedList可以多么快速地从列表的端点插入和移除元素,这正是对Queue行为所做的优化.
 * 通常,你可以值调用Tester.run(),传递容器和tests列表.但是,在这里我们必须覆盖initialize()方法,使得List在每次测试
 * 之前,都会被清空并重新填充,否则在不同的测试过程中,对于List尺寸的控制将丧失.ListTester继承自Tester,并使用Counti-
 * ngIntegerList执行这种初始化.run()便捷方法也被覆盖了.
 * 我们还想将数组访问与容器访问进行比价(主要是与ArrayList比较).在main()的每一个测试中,使用匿名内部类创建一个特殊
 * 的Test对象.initialize()方法将覆盖为在每次被调用时都创建一个新对象(此时会忽略container对象,因此对于这个Tester
 * 构造器来说,null就是传递进来的container参数).这个新对象是使用Generated.array()和Arrays.asList()创建的.在本例
 * 中,只有两个测试可以执行,因为你不能再使用背后由数组支撑的List时,插入或移除元素,因此List.subList()方法被用来在
 * tests列表中选取想要执行的测试.
 * 对于随机访问的get()和set()操作,背后由数组支撑的List只比ArrayList稍快一点,但是对于LinkedList,相同的操作会变得
 * 异常引人注目的高昂,因为它本来就不是针对随机访问操作而设计的.
 */
