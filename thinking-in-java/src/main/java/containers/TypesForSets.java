package containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
    int i;
    public SetType(int n) {
        i = n;
    }
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType) o).i);
    }
    public String toString() {
        return Integer.toString(i);
    }
}
class HashType extends SetType {
    public HashType(int n) {
        super(n);
    }
    public int hashCode() {
        return i;
    }
}
class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int n) {
        super(n);
    }
    public int compareTo(TreeType arg) {
        return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
    }
}
public class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++)
                set.add(
                    type.getConstructor(int.class).newInstance(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }
    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);//Try to add duplicates
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        test(new TreeSet<>(), TreeType.class);
        //Things that don't work:
        test(new HashSet<>(), SetType.class);
        test(new HashSet<>(), TreeType.class);
        test(new LinkedHashSet<>(), SetType.class);
        test(new LinkedHashSet<>(), TreeType.class);
        try {
            test(new TreeSet<>(), SetType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), HashType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**
 * 避免代码重复,创建基类SetType,重写equals方法
 * HashType继承自SetType,并且添加hashCode()方法
 * TreeType实现Comparable接口
 * fill()和test()方法都是用泛型定义的,避免代码重复.
 * HashSet以某种神秘的顺序保存所有元素,LinkedHashSet按照元素插入的顺序保存元素,而TreeSet按照排序顺序(降序)维护元素.
 */
