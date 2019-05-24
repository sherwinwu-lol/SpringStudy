package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(
                CollectionData.list(//Convenience method
                        new RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<Integer>(
                new CollectionData<Integer>(//Convenience method
                        new RandomGenerator.Integer(), 10)));
    }
}
