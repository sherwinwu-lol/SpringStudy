package containers;

import java.util.LinkedHashMap;

import static net.mindview.util.Print.print;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        print(linkedMap);
        //Least-recently-used order:
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);
        for (int i = 0; i < 6; i++) //Cause accesses:
            linkedMap.get(i);
        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
}
/**
 * LRU:最近最少使用算法
 *      访问过的元素被移动到队列最后面
 */
