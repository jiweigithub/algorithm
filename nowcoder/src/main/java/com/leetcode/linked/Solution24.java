package com.leetcode.linked;

import java.util.Objects;

public class Solution24 {

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ListNode listNode = solution24.swapPairs(node1);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
