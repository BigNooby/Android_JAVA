package com.hhcui.data_structure;

/**
 * 数组问题要考虑边界值 0、size-1、size
 *
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E> {
    int size;

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size is:" + size + ",but index is:" + index);
        }
    }

    protected void checkRangeAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("size is:" + size + ",but index is:" + index);
        }
    }

    @Override
    public boolean isContain(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


}
