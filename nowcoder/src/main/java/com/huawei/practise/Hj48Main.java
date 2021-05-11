package com.huawei.practise;

import java.util.Scanner;

/**
 * 从单向链表中删除指定节点的值
 * <p>
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * <p>
 * 链表的值不能重复。
 * <p>
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 * <p>
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 * <p>
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 * <p>
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 * <p>
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 * <p>
 * 最后的链表的顺序为 2 7 3 1 5 4
 * <p>
 * 最后一个参数为2，表示要删掉节点为2的值
 * 删除 结点 2
 * <p>
 * 则结果为 7 3 1 5 4
 * <p>
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 测试用例保证输入合法
 * <p>
 * <p>
 * 输入描述:
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 * <p>
 * 输出描述:
 * 输出一行
 * 输出删除结点后的序列，每个数后都要加空格
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5 2 3 2 4 3 5 2 1 4 3
 * 输出
 * 复制
 * 2 5 4 1
 * 说明
 * 形成的链表为2->5->3->4->1
 * 删掉节点3，返回的就是2->5->4->1
 * 示例2
 * 输入
 * 复制
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 输出
 * 复制
 * 7 3 1 5 4
 * 说明
 * 如题
 */
public class Hj48Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = Integer.parseInt(scanner.next());
            int headVal = Integer.parseInt(scanner.next());
            Node head = new Node(headVal, null);
            NodeList nodeList = new NodeList();
            nodeList.add(head, 0);
            for (int i = 1; i < count; i++) {
                int nodeVal = Integer.parseInt(scanner.next());
                int parentVal = Integer.parseInt(scanner.next());
                Node node = new Node(nodeVal, null);
                nodeList.add(node, parentVal);
            }
            int delVal = Integer.parseInt(scanner.next());
            nodeList.remove(delVal);
            Node current = nodeList.head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }


}

class NodeList {
    Node head;

    public void add(Node node, int parentVal) {
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.val == parentVal) {
                break;
            }
            current = current.next;
        }
        Node next = current.next;
        current.next = node;
        node.next = next;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public void remove(int val) {
        if (head.val == val) {
            head = head.next;
            return;
        }
        Node dNode = new Node(0, head);
        Node current = dNode.next;
        boolean flag = false;
        while (current != null) {
            if (current.next.val == val) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.next = current.next.next;
        }
    }

}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
