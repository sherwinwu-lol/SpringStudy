package com.wusd.util;

import java.util.Iterator;

public interface Collection<E> extends Iterable<E> {
    boolean add(E e);
    boolean addAll(Collection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    @Override
    boolean equals(Object o);
    @Override
    int hashCode();
    boolean isEmpty();
    @Override
    Iterator<E> iterator();
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    int size();
    Object[] toArray();
    <T> T[] toArray(T[] a);
}
