package containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;

public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString(String str) {
        s = str;
        created.add(s);
        //id is the total number of instances of this string in use by CountedString:
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }
    public int hashCode() {
        //The very simple approach:
        //return s.hashCode() * id;
        //Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString) o).s) &&
                id == ((CountedString) o).id;
    }
    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);//Autobox int -> Integer
        }
        print(map);
        for (CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
/**
 * CountedString由一个String和一个id组成,此id代表包含相同String的CountedString对象的编号.所有的String都被存储在static
 * ArrayList中,在构造器中通过迭代遍历此ArrayList完成对id的计算.
 * hashCode()和equals()都基于CountedString的这两个域来生成结果;如果它们只基于String或者只基于id,不同的对象就可能产生相
 * 同的值.
 * 在main()中,使用相同的String创建了多个CountedString对象.这说明,虽然String相同,但是由于id不同,所以使得它们的散列码并不
 * 相同.在程序中,HashMap被打印了出来,因此可以看到它内部是如何存储元素的(以无法辨别的次序),然后单独查询每一个键,以此证明查
 * 询机制工作正常.
 */
