package com.wusd.fifth;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>();
        }
        E result = initVal;
        for (E e : snapshot)
            ;
//            result = f.apply(result, e);
        return result;
    }
}
