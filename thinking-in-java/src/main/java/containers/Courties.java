package containers;

import java.util.*;

import static net.mindview.util.Print.print;

public class Courties {
    public static final String[][] DATA = {
            //Africa
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"},
            {"BENIN", "Porto-Novo"}, {"BOTSWANA", "Gaberone"},
            {"BURKINA FASO", "Ouagadougou"},
            {"BURUNDI", "Bujumbura"},
            {"CAMEROON", "Yaounde"}, {"CAPE VERDE", "Praia"},
            {"CENTRAL AFRICAN REPUBLIC", "Bangui"},
            {"CHAD", "N'djamena"}, {"COMOROS", "Moroni"},
            {"CONGO", "Brazzaville"}, {"DJIBOUTI", "Dijibouti"},
            {"EGYPT", "Cairo"}, {"EQUATORIAL GUINEA", "Malabo"},
            {"ERITREA", "Asmara"}, {"ETHIOPIA", "Addis Ababa"},
            {"GABON", "Libreville"}, {"THE GAMBIA", "Banjul"},
            {"GHANA", "Accra"}, {"GUINEA", "Conakry"},
            {"BISSAU", "Bissau"},
            {"COTE D'IVOIR (IVORY COAST)", "Yamoussoukro"},
            {"KENYA", "Nairobi"}, {"LESOTHO", "Maseru"},
            {"LIBERIA", "Monrovia"}, {"LIBYA", "Tripoli"},
            {"MADAGASCAR", "Antananarivo"}, {"MALAWI", "Lilongwe"},
            {"MALI", "Bamako"}, {"MAURITANIA", "Nouakchott"},
            {"MAURITIUS", "Port Louis"}, {"MOROCCO", "Rabat"},
            {"MOZAMBIQUE", "Maputo"}, {"NAMIBIA", "Windhoek"},
            {"NIGER", "Niamey"}, {"NIGERIA", "Abuja"},
            {"RWANDA", "Kigali"}
    };
    private static class FlyweightMap extends AbstractMap<String, String> {
        public Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet(-1);
        }
        private static class Entry implements Map.Entry<String, String> {
            int index;
            Entry(int index) {
                this.index = index;
            }
            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }
            public String getKey() {
                return DATA[index][0];
            }
            public String getValue() {
                return DATA[index][1];
            }
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;
            EntrySet(int size) {
                if (size < 0)
                    this.size = 0;
                //Can't be any bigger than the array:
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }
            public int size() {
                return size;
            }
            private class Iter implements Iterator<Map.Entry<String, String>> {
                //Only one Entry object per Iterator:
                private Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
                public void remove(){
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }
            private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);
            public Set<Map.Entry<String, String>> entrySet() {
                return entries;
            }
        }
        //Create a partial map of 'size' countries:
        static Map<String, String> select(final int size) {
            return new FlyweightMap() {
                public Set<Map.Entry<String, String>> entrySet() {
                    return new EntrySet(size);
                }
            };
        }
        static Map<String, String> map = new FlyweightMap();
        public static Map<String, String> capitals() {
            return map;//The entire map
        }
        public static Map<String, String> capitals(int size) {
            return select(size);//A partial map
        }
        static List<String> names = new ArrayList<>(map.keySet());
        //All the names:
        public static List<String> names() {
            return names;
        }
        //A partial list:
        public static List<String> names(int size) {
            return new ArrayList<>(select(size).keySet());
        }

        public static void main(String[] args) {
            print(capitals(10));
            print(names(10));
            print(new HashMap<String, String>(capitals(3)));
            print(new LinkedHashMap<String, String>(capitals(3)));
            print(new TreeMap<String, String>(capitals(3)));
        }
    }
}
/**
 * 二维数组String DATA是public的,因此它可以在其他地方使用.FlyweightMap必须实现entrySet()方法,
 * 它需要定制的Set实现和定制的Map.Entry类.这里正是享元部分:每个Map.Entry对象都只存储了它的索引,
 * 而不是实际的键和值.当你调用getKey()和getValue()时,它们会使用该索引来返回恰当的DATA元素.
 * EntrySet可以确保它的size不会大于DATA.
 * 你可以在EntrySet.Iterator中看到享元其他部分的实现.与为DATA中的每个数据对都创建的Map.Entry
 * 对象不同,每个迭代器只有一个Map.Entry.Entry对象被用作数据的视窗,它只会包含在静态字符串数组中
 * 的索引.你每次调用迭代器的next()方法时,Entry中的index都会递增,使其指向下一个元素对,然后从next()
 * 返回该Iterator所持有的单一的Entry对象.
 * select()方法将产生一个包含指定尺寸的EntrySet的FlyweightMap,它会被用于重载过的capitals()和
 * names()方法,正如在main()中所演示的那样.
 * 对于某些测试,Countries的尺寸受限会成为问题.我们可以采用与产生定制容器相同的方法来解决,其中定制
 * 容器是经过初始化的,并且具有任意尺寸的数据集.下面的类是一个List,它可以具有任意尺寸,并且用Integer数据
 * (有效地)进行了预初始化:
 */
