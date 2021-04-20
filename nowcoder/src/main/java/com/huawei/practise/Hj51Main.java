package com.huawei.practise;

import java.util.Scanner;

/**
 * 输出链表中倒数第k个节点
 */
public class Hj51Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            Node51List node51List = new Node51List();
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                int val = scanner.nextInt();
                Node51 node51 = new Node51(val);
                node51List.add(node51);
            }
            int index = scanner.nextInt();
            node51List.getLastNode(index);
        }
    }
}

class Node51List {
    Node51 head;

    public void add(Node51 node51) {
        if (head == null) {
            head = node51;
            return;
        }
        Node51 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node51;
    }

    public void getLastNode(int index) {
        int length = 0;
        Node51 current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        Node51 nowNode = head;
        if (index <= 0 || index > length) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < length - index; i++) {
            nowNode = nowNode.next;
        }
        if (nowNode != null) {
            System.out.println(nowNode.val);
            return;
        }
    }
}

class Node51 {

    int val;

    Node51 next;

    public Node51(int val) {
        this.val = val;
    }
}
