package com.wusd.util;

import java.util.Iterator;

public interface List<E> extends Collection<E> {
    boolean add(E e);
    void add(int i, E e);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int i, Collection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    boolean equals(Object o);
    E get(int i);
    int hashCode();
    int indexOf(Object o);
    boolean isEmpty();
    Iterator<E> iterator();
    ListIterator<E> listIterator();
    int lastIndexOf(Object o);
}
