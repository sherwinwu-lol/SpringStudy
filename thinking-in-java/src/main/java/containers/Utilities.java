package containers;

import java.util.*;

import static net.mindview.util.Print.print;

public class Utilities {
    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" "));
    public static void main(String[] args) {
        print(list);
        print("'list' disjoint (Four)?: " +
                Collections.disjoint(list,
                    Collections.singletonList("Four")));
        print("max: " + Collections.max(list));
        print("min: " + Collections.min(list));
        print("max w/ comparator: " + Collections.max(list,
                String.CASE_INSENSITIVE_ORDER));
        List<String> subList = Arrays.asList("Four five six".split(" "));
        print("indexOfSubList: " + Collections.indexOfSubList(list, subList));
        print("lastIndexOfSubList:  " + Collections.lastIndexOfSubList(list, subList));
        Collections.replaceAll(list, "one", "Yo");
        print("replace: " + list);
        Collections.reverse(list);
        print("reverse: " + list);
        Collections.rotate(list, 3);
        print("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        print("copy: " + list);
        Collections.swap(list, 0, list.size() - 1);
        print("swap: " + list);
        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);
        Collections.fill(list, "pop");
        print("fill: " + list);
        print("frequency of 'pop': " + Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        print("dups: " + dups);
        print("'list' disjoint 'dups'?: " + Collections.disjoint(list, dups));
        //Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements())
            v.addElement(e.nextElement());
        //Converting an old-style Vector to a List via an Enumeration:
        ArrayList<String> arrayList = Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }
}
/**
 * 对特定类型的"不可修改的"方法的调用并不会产生编译时的检查,但是转换完成后,任何会改变容器内容的操作都会引起
 * UnsupportedOperationException异常.
 * 无论哪一种情况,在将容器设为只读之前,必须填入有意义的数据.装载数据后,就应该使用"不可修改的"方法返回的引用
 * 去替换掉原本的引用.这样,就不要担心无意中修改了只读的内容.另一方面,此方法允许你保留一份可修改的容器,作为类
 * 的private成员,然后通过某个方法调用返回对该容器的"只读"的引用.这样一来,就只有你可以修改容器的内容,而别人只
 * 能读取.
 */
