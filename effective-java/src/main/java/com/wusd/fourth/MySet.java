package com.wusd.fourth;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        Map map = new HashMap();
        return new MyIterator();
    }
    @Override
    public int size() {
        return 0;
    }
    private class MyIterator implements Iterator<E> {
        public boolean hasNext() {
            return false;
        }
        public E next() {
            return null;
        }
    }
}
