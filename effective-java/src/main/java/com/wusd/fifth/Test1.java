package com.wusd.fifth;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {

    }
    static Object reduce(List list, Function f, Object initVal) {
        synchronized (list) {
            Object result = initVal;
            for (Object o : list)
                result = f.apply(result, o);
            return result;
        }
    }
    //Reduction without generics or concurrency flaw
//    static Object reduce1(List list, Function f, Object initVal) {
//        Object[] snapshot = list.toArray();//Locks list internally
//        Object result = initVal;
//        for (E e : snapshot)
//            result = f.apply(result, e);
//        return result;
//    }
}
interface Function<T> {
    Object apply(T arg1, T arg2);
}
