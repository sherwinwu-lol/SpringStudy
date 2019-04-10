package util;

public interface List<E> extends Collection<E> {
    @Override
    boolean add(E e);

    void  add(int index, E e);

    @Override
    boolean addAll(Collection<? extends E> collection);

    boolean addAll(int index, Collection<? extends E> collection);
    @Override
    void clear();

    @Override
    boolean contains(Object o);

    E get(int index);

    @Override
    int hashCode();

    int indexOf(Object o);

    @Override
    boolean isEmpty();

    @Override
    Iterator<E> iterator();

    int lastIndexOf(Object o);

    boolean remove(int index);

    @Override
    boolean remove(Object o);

    @Override
    boolean removeAll(Collection<?> collection);

    @Override
    boolean retainAll(Collection<?> collection);

    E set(int index, E e);

    @Override
    int size();

    List<E> subList(int beginIndex, int endIndex);

    @Override
    Object[] toArray();

    @Override
    <T> T[] toArray(T[] arr);
}
