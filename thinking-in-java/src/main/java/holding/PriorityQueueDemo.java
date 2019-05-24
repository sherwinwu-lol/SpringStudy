package holding;


import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        QueueDemo.printQ(priorityQueue);
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 4, 1, 1, 2, 3,
                9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);

        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray())
            charSet.add(c); //Autoboxing
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}
/**
 * 你可以看到,重复时允许的,最小的值拥有最高的优先级(如果是String,空格也可以算作值,并且比字母优先级高).
 * 为了展示你可以使用怎样额方法通过提供自己的Comparator对象来改变排序,
 * 第三个对PriorityQueue<Integer>的构造器调用,和第二个对PriorityQueue<String>的调用使用了由Collection.reverseOrder()
 * 产生的反序的Comparator.
 * 最后一部分添加了一个HashSet来消除重复Character,这么做只是为了增添点乐趣.
 */
