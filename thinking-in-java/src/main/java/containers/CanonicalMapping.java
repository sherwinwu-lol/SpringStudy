package containers;

import java.util.WeakHashMap;

class Element {
    private String ident;
    public Element(String id) {
        ident = id;
    }
    public String toString() {
        return ident;
    }
    public int hashCode() {
        return ident.hashCode();
    }
    public boolean equals(Object r) {
        return r instanceof Element &&
                ident.equals(((Element) r).ident);
    }
    protected void finalize() {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}
class Key extends Element {
    public Key(String id) {
        super(id);
    }
}
class Value extends Element {
    public Value(String id) {
        super(id);
    }
}
public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        //Or, choose size via the command line:
        if (args.length > 0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keys[i] = k;//Save as "real" references
            map.put(k, v);
        }
        System.gc();
    }
}
/**
 * Key类必须由hashCode()和equals(),因为在散列数据结构中,它被用作键.有关hashCode()的主题
 * 在本章前面部分已经描述过了.
 * 运行此程序,会看到垃圾回收器每隔三个键就跳过一个,因为指向那个键的普通引用被存入了keys数组,
 * 所以那些对象不能被垃圾回收器回收.
 */
