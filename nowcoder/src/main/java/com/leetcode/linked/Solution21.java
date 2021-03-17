package com.leetcode.linked;

/**
 * 合并两个有序链表
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Solution21 {

    /**
     * 迭代法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建前置节点
        ListNode preHead = new ListNode(-1);
        //使辅助指针指向前置节点
        ListNode current = preHead;
        //当l1和l2都不为空时，进行处理
        while (l1 != null && l2 != null) {
            //如果l1的值小于等与l2的值
            if (l1.val <= l2.val) {
                //将l1添加到辅助指针的下一个节点
                current.next = l1;
                //l1后移
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            //辅助指针后移
            current = current.next;
        }

        current.next = (l1 == null ? l2 : l1);

        return preHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = l1;
        while (current != null) {
            ListNode node = new ListNode(current.val);
            addAndOrder(head, node);
            current = current.next;
        }
        current = l2;
        while (current != null) {
            ListNode node = new ListNode(current.val);
            addAndOrder(head, node);
            current = current.next;
        }
        return head.next;
    }

    public void addAndOrder(ListNode head, ListNode node) {
        ListNode current = head.next;
        while (current.next != null) {
            if (current.next.val >= node.val) {
                break;
            }
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
    }
}
