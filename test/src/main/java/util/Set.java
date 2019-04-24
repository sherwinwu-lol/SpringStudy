package util;

public interface Set<E> extends Collection<E> {
    @Override
    boolean add(E e);
    @Override
    boolean addAll(Collection<? extends E> collection);
    @Override
    void clear();

    @Override
    boolean contains(Object o);

    @Override
    boolean containsAll(Collection<?> collection);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    boolean isEmpty();

    @Override
    Iterator<E> iterator();

    @Override
    boolean remove(Object o);

    @Override
    boolean removeAll(Collection<?> collection);

    @Override
    boolean retainAll(Collection<?> collection);

    @Override
    int size();

    @Override
    Object[] toArray();

    @Override
    <T> T[] toArray(T[] arr);
}
