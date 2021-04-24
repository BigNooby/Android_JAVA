package com.hhcui.data_structure;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static final class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {//如果是0位置，就是把first设置为新的first的next节点即可
            first = new Node<>(element, first);
        } else {
            Node<E> prevNode = node(index - 1);
//        Node<E> nextNode = node(index);
//        Node<E> nextNode = prevNode.next;
            /*
             *查找出了前一个节点，想知道后面的直接next就可以，不需要node(index)
             */
            prevNode.next = new Node<>(element, prevNode.next);
        }
        size++;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void set(int index, E element) {
        node(index).element = element;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public void remove(int index) {
        Node<E> node = node(index - 1);
        if (index == 0) {
            first = first.next;
        } else {
            node.next = node.next.next;
        }

        size--;
    }


    /**
     * 查找index位置的Node对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        checkRange(index);//这里检查了index的范围，不需要判断后面first是否为null
        Node<E> node = first;//应用first，不能直接用first指向的对象
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        Node<E> node = first;//应用first，不能直接用first指向的对象
//        while (node != null) {
//            stringBuilder.append(node.element).append(",");
//            node = node.next;
//        }
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",").append(node.element);
            } else {
                stringBuilder.append(node.element);
            }
            node = node.next;
        }
//        String append = stringBuilder.toString();
//        if (append.endsWith(",")) {
//            stringBuilder = new StringBuilder(append.substring(0, append.length() - 1));
//        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
