package com.hhcui.data_structure;

/**
 * 数组接口方法抽象出来
 *
 * @param <E>
 */
public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    int size();

    void clear();

    void add(E element);

    void add(int index, E element);

    int indexOf(E element);

    void set(int index, E element);

    E get(int index);

    void remove(int index);

    boolean isEmpty();

    boolean isContain(E element);

}
