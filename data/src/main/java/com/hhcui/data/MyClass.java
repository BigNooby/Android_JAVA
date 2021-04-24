package com.hhcui.data;

public class MyClass {

    public static void main(String[] args) {
//        System.out.println(fib(5));
        ArrayList list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println(list.toString());
    }

    /**
     * 斐波那契数列
     * 0 1 2 3 5 8 13 ...
     * 时间复杂度为O(n)
     *
     * @param n 第几个斐波那契数
     * @return 第n个斐波那契数的值
     */
    public static int fib(int n) {
        if (n <= 1)
            return n;
        int first = 0;
        int second = 1; 
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = first + second;
            first = second;
            second = sum;

        }
        return sum;
    }

    /**
     * 斐波那契数列
     * 0 1 2 3 5 8 13 ...
     * 使用递归方式，时间复杂度为 O(2^n)
     *
     * @param n 第几个斐波那契数
     * @return 第n个斐波那契数的值
     */
    public static int fib2(int n) {
        if (n <= 1)
            return n;
        return fib2(n - 1) + fib(n - 2);
    }
}