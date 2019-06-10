package com.wusd.fifth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test3 {
    //Uses raw types - unacceptable! (Item 23)
//    public static Set union(Set s1, Set s2) {
//        Set result = new HashSet(s1);
//        result.addAll(s2);
//        return result;
//    }
    //Generic method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    //Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList("Tom Dick Harry".split(" ")));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry Moe Curly".split(" ")));
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}
