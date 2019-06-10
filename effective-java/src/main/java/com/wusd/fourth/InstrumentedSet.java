package com.wusd.fourth;

import com.wusd.third.ForwardingSet;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;
    public InstrumentedSet(Set<E> s) {
        super(s);
    }
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }
    public static void main(String[] args) {
    }
}
