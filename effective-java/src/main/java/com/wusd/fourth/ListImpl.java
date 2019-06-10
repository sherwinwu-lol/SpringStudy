package com.wusd.fourth;

import java.util.AbstractList;
import java.util.List;

public class ListImpl {
    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }
            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
