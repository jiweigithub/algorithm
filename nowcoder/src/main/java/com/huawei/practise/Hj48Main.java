package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                System.out.print(current.val+" ");
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
