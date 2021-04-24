package com.hhcui.data_structure;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {

    private final static int ELEMENT_NOT_FOUND = -1;
    private final static int DEFAULT_capacity_size = 2;

    E[] elements;

    public ArrayList() {
        this(DEFAULT_capacity_size);
    }

    public ArrayList(int size) {

        elements = (E[]) new Object[Math.max(size, DEFAULT_capacity_size)];
    }


    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        checkRangeAdd(index);
        ensureCapacity(size + 1);//保证有size+1的空间，就可以存储新增元素
        /*
         * index 之后的元素，从尾部开始，分别往后挪
         * */
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public boolean isContain(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void set(int index, E element) {
        elements[index] = (E) element;
    }

    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    public void remove(int index) {
        elements[index] = null;
        checkRange(index);
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
//        size--;
        elements[--size] = null; //清空最后一个的对象地址，销毁内存
    }

    /**
     * 泛型需要针对null 进行判断
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    public void clear() {
//        elements = null;
        //保留数组地址保持，销毁地址指向的对象内存。
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",").append(elements[i]);
            } else {
                stringBuilder.append(elements[i].toString());
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
    /**
     * 扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        E[] newElements = (E[]) new Object[oldCapacity + (oldCapacity >> 1)];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
//        System.arraycopy();//java copy api
        elements = newElements;
    }
}
