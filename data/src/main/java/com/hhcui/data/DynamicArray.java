package com.hhcui.data;

public class DynamicArray implements DynamicInterface {
    private int mSize;
    private int[] mElements;
    private final static int DEFAULT_SIZE = 10;
    private final static int NOT_FOUND_VALUE = -1;


    public DynamicArray(int size) {
        size = Math.max(size, DEFAULT_SIZE);
        this.mSize = size;
        mElements = new int[size];
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public void add(int element) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean isEmpty() {
        return mSize == 0;
    }

    @Override
    public int indexOf(int element) {
        if (mSize <= 0) {
            return NOT_FOUND_VALUE;
        }
        for (int i = 0; i < mSize - 1; i++) {
            if (element == mElements[i]) {
                return i;
            }
        }
        return NOT_FOUND_VALUE;
    }

    @Override
    public int set(int index, int element) {
        if (index >= mSize || index < 0) {
            throw new IndexOutOfBoundsException("size is " + mSize + ",but index is " + index);
        }
        int old = mElements[index];
        mElements[index] = element;
        return old;
    }

    @Override
    public int get(int index) {
        if (index >= mSize || index < 0) {
            throw new IndexOutOfBoundsException("size is " + mSize + ",but index is " + index);
        }
        return mElements[index];
    }

    @Override
    public boolean contain(int element) {
        return !(indexOf(element) == DEFAULT_SIZE);
    }

    @Override
    public void clear() {
        mSize = 0;
    }
}
