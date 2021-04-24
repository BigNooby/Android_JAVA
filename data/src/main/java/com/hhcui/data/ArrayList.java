package com.hhcui.data;

public class ArrayList {
    private int size;
    private final static int ELEMENT_NOT_FOUND = -1;
    private final static int DEFAULT_capacity_size = 10;

    int[] elements;

    public ArrayList() {
        this(DEFAULT_capacity_size);
    }

    public ArrayList(int size) {
        elements = new int[Math.max(size, DEFAULT_capacity_size)];
    }


    public int size() {
        return size;
    }

    public void add(int element) {
        add(size, element);
    }

    public void add(int index, int element) {
        elements[size] = element;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isContain(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void set(int index, int element) {
        elements[index] = element;
    }

    public int get(int index) {
        return elements[index];
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i++] = elements[i];
        }
        size--;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }


    public void clear() {
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=" + size + ", elements=[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append("," + elements[i]);
            } else {
                stringBuilder.append(+elements[i]);
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
