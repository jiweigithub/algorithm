package com.huawei.leetcode;

/**
 * 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode preNode = head;
        ListNode ansNode = new ListNode();
        while (preNode != null) {
            ListNode addNode = preNode;
            preNode = preNode.next;
            addNode.next = null;
            if (ansNode.next == null) {
                ansNode.next = addNode;
            } else {
                ListNode next = ansNode.next;
                addNode.next = next;
                ansNode.next = addNode;
            }
        }
        return ansNode.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
