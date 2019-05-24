package containers;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }
    public Integer get(int index) {
        return Integer.valueOf(index);
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
/**
 * 为了从AbstractList创建只读的List,你必须实现get()和size().这里再次使用了享元解决方案:
 *      当你寻找值时,get()将产生它,因此这个List实际上不必组装.
 */
