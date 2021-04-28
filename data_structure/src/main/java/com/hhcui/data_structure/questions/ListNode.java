package com.hhcui.data_structure.questions;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder nextSB = new StringBuilder();
        while (next != null) {
            nextSB = nextSB.append(next.val).append(",");
            next = next.next;
        }
        String nextStr = "";
        if (nextSB.length() > 1) {
            nextStr = nextSB.substring(0, nextSB.length() - 1);
        }
        return "ListNode{" +
                "val=" + val +
                ",next=" + nextStr +
                '}';
    }
}