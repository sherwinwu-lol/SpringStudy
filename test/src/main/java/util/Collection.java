package util;

public interface Collection<E> extends Iterator<E> {
    boolean add(E e);
    boolean addAll(Collection<? extends E> collection);
    void clear();
    boolean contains(Object o);
    @Override
    boolean equals(Object o);
    @Override
    int hashCode();
    boolean isEmpty();
    Iterator iterator();
    boolean remove(Object o);
    boolean removeAll(Collection<?> collection);
    boolean retainAll(Collection<?> collection);
    int size();
    Object[] toArray();
    <T> T[] toArray(T[] arr);
}
