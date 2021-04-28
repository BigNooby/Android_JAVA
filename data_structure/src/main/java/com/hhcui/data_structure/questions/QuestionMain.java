package com.hhcui.data_structure.questions;

public class QuestionMain {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(_1_两数之和.twoSum(new int[]{2, 1, 3}, 5)));
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        System.out.println(node);
        System.out.println(_18_删除链表的节点.deleteNode(node, 4));
    }
}
