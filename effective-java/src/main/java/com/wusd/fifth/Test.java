package com.wusd.fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, new Integer(42));
        String s = strings.get(0);//Compiler-generated cast
    }
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
    //Use of raw type for unknown element type - don't do this!
    static int numElemnetsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
    //Unbounded wildcard type - typesafe and flexible
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}
