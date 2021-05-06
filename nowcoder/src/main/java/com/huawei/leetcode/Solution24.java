package com.huawei.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
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
        ListNode listNode = solution24.swapPairs2(node1);
        System.out.println(listNode);
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 迭代法
     * <p>
     * 思路与算法
     * <p>
     * 也可以通过迭代的方式实现两两交换链表中的节点。
     * <p>
     * 创建哑结点 dummyHead，令 dummyHead.next = head。
     * 令 temp 表示当前到达的节点，初始时 temp = dummyHead。
     * 每次需要交换 temp 后面的两个节点。
     * <p>
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。
     * 否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     * <p>
     * 具体而言，交换之前的节点关系是 temp -> node1 -> node2，
     * 交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
     * <p>
     * <p>
     * temp.next = node2
     * node1.next = node2.next
     * node2.next = node1
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        //创建哑节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            //获得当前节点的下一个节点
            ListNode next1 = temp.next;
            //获得当前节点的下下一个节点
            ListNode next2 = temp.next.next;
            //当前节点的下一个节点指向原先的下下一个节点
            temp.next = next2;
            //原先的下一个节点指向原先下下一个节点的下一个节点
            next1.next = next2.next;
            //原先的下下一个节点的下一个节点指向next1
            next2.next = next1;
            //temp后移
            temp = next1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
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
