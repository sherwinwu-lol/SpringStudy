package com.wusd.second;

import java.util.Arrays;
import java.util.EmptyStackException;

//Can you spot the "memory leak"?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;//Eliminate obsolete reference
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
/**
 * 1.只要类是自己管理内存,程序员就应该警惕内存泄漏问题.一旦元素被释放掉,
 *  则该元素中包含的任何对象引用都应该被清空.
 * 2.缓存
 * 3.监听器和其他回调
 */
