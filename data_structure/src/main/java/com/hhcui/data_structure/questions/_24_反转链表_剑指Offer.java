package com.hhcui.data_structure.questions;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class _24_反转链表_剑指Offer {
    /**
     * 递归调用， 5 4 3 2 1
     * 如果传入的4 ，那么结果应该是new head->1->2->3->4,所以4的next应该是head，head.next 应该是null；
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //空或者只有一个节点 直接返回，不用反转
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        //空或者只有一个节点 直接返回，不用反转
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;//先保存next节点备用
            pre = cur;
            cur.next = pre;
            cur = nxt;
        }
        return pre;
    }
}
