package containers;

import net.mindview.util.Countries;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    //Choose a prime number for the hash table size,
    //to achieve a uniform distribution:
    static final int SIZE = 997;
    //You can't have a physical array of generics,
    //but you can upcast to one:
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);//Replace old with new
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets)  {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
    public static void main(String[] args) {
        SimpleHashMap<String , String> m =
                new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
/**
 * 由于散列表中的"槽位"(slot)通常称为桶位(bucket),因此我们将表示实际散列表的数组命名为bucket.
 * 为使散列分布均匀,桶的数量通常使用质数.注意,为了能够自动处理冲突,使用了一个LinkedList的数组,
 * 每个新的元素只是直接添加到list末尾的某个特定桶位中.即使Java不允许你创建泛型数组,那你也可以
 * 创建指向这种数组的引用.这里,向上转型为这种数组是很方便的,这样可以防止在后面的代码中进行额外
 * 的转型.
 * 对于put()方法,hashCode()将针对键而被调用,并且其结果被强制转换为正数.为了使产生的数字适合
 * bucket数组的大小,取模操作符按照该数组的尺寸取模.如果数组的某个位置是null,这表示还没有元素
 * 被散列至此,所以,为了保持刚散列到该定位的对象,需要创建一个新的LinkedList.一般的过程是,查看
 * 当前位置的list中是否有相同的元素,如果有,则将旧的值付给oldValue,然后用新的值取代旧的值.标记
 * found用来跟踪是否找到(相同的)旧的键值对,如果没有,则将新的对添加到list的末尾.
 * get()方法按照与put()方法相同的方式计算在buckets数组中的索引(这很重要,因为这样可以保证两个
 * 方法可以计算出相同的位置)如果此位置有LinkedList存在,就对其进行查询.
 * 注意,这个实现并不意味着对性能进行了调优;它只是想要展示散列映射表执行的各种操作.如果你浏览一
 * 下java.util.HashMap的源代码,你就会看到一个调过优的实现.通用,为了简单,SimpleHashMap使用了
 * 与SlowMap相同的方式来实现entrySet(),这个方法有些过于简单,不能用于通用的Map.
 */
