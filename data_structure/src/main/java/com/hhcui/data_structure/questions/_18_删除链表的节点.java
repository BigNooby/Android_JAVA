package com.hhcui.data_structure.questions;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class _18_删除链表的节点 {

    public static ListNode deleteNode(ListNode head, int element) {
        if (head == null) return null;
        if (head.val == element) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == element) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur.next = cur.next.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;

    }

    public static ListNode deleteNode3(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                return head.next;
            }
            temp = temp.next;
        }
        return head.next;
    }


}
