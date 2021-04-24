package com.hhcui.data;

public interface DynamicInterface {
    /**
     * 数组大小
     *
     * @return 数组大小
     */
    int size();

    /**
     * 添加元素
     *
     * @param element 需要添加的元素
     */
    void add(int element);

    /**
     * 删除所在index位置的元素
     *
     * @param index 删除的位置
     */
    void remove(int index);

    /**
     * 判断是否为空
     */
    boolean isEmpty();

    /**
     * 元素在数组内的位置
     *
     * @param element 元素
     * @return 位置
     */
    int indexOf(int element);

    /**
     * 插入位置新元素，返回旧的元素
     *
     * @param index   位置
     * @param element 新元素
     * @return 旧元素
     */
    int set(int index, int element);

    /**
     * 获取位置元素
     * @param index 位置
     * @return 元素
     */
    int get(int index);

    /**
     * 是否包含元素
     *
     * @param element 元素
     * @return boolean
     */
    boolean contain(int element);

    /**
     * 清空数组
     */
    void clear();


}
