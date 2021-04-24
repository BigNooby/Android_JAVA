package com.hhcui.data_structure;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Object> list = new ArrayList<>();
//        //数组指向 对象地址的数组， 各个地址指向对象内存空间
//        list.add(new Person("hhcui", 30));
//        list.add(null);
//        list.add(new Person("myyang", 20));
//        list.add(null);
//        list.add(new Person("qiuqiu", 0));
//        list.add(10);
//        list.add(2,99);
////        list.clear();
//        System.gc();//提醒gc回收 没有指向、引用的对象。
//        System.out.println(list.isEmpty());
//        System.out.println(list.toString());
//        List<String> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(11);
        list1.add(22);
//        list1.add(0,11);
//        list1.add(33);

        list1.add(44);
        list1.add(55);
        list1.add(66);
        System.out.println(list1.toString());
    }
}
