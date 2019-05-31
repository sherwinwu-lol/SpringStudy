package containers;

import java.util.*;

public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests =
            new ArrayList<>();
    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }
    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
/**
 * 除了IdentityHashMap,所有的Map实现的插入操作都会随着Map尺寸的变大而明显变慢.
 * 但是,查找的代价通常比插入要小很多,这是个好消息,因为我们只想查找元素的操作要比执
 * 行插入元素的操作多得多.
 * Hashtable的性能大体上与HashMap相当,因为HashMap是用来替代Hashtable的,因此它
 * 们使用了相同的底层存储和查找机制(你稍后就会学习它),这并没有什么令人吃惊的.
 * TreeMap通常比HashMap要慢.与使用TreeSet一样,TreeMap是一种创建有序列表的方式.
 * 树的行为时:总是保证有序,并且不必进行特殊的排序.一旦你填充了一个TreeMap,就可以
 * 调用keySet()方法来获取键的Set视图,然后调用toArray()来产生有这些键构成的数组.之后,
 * 你可以使用静态方法Arrays.binarySearch()在排序数组中快速查找对象.当然,这只有在
 * HashMap的行为不可接受的情况下才有意义,因为它维护散列数据结构的同时还要维护链
 * 表(以保证插入顺序).正是由于这个列表,使得其迭代速度更快.
 * IdentityHashMap则具有完全不同的性能,因为它使用==而不是equals()来比较元素.
 * WeekHashMap将在本章稍后介绍.
 */
