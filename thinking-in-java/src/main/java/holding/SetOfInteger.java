package holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(10000));
        System.out.println(intset);
    }
}
/**
 * 因为hash 2^16方存入的顺序都相同,导致hashSet有序,实际上仍然无序
 */
