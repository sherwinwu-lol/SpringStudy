package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile("thinking-in-java/src/main/java/holding/" +
                "SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
