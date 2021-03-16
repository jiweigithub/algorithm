package com.shangguigu.datastructures.stack;

import java.util.Scanner;

/**
 * 使用链表模拟栈
 */
public class LinkedStack {

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("list：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：压栈");
            System.out.println("pop：弹栈");
            System.out.println("peek：查看栈顶数据");
            key = scanner.next();
            switch (key) {
                case "list":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    int val = scanner.nextInt();
                    try {
                        stack.push(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "peek":
                    try {
                        int res = stack.peek();
                        System.out.printf("栈顶的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

    private int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        StackNode current = head;
        return current.next.val;
    }

    private void list() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        StackNode current = head;
        while (current.next != null) {
            System.out.println(current.next.val);
            current = current.next;
        }
    }

    private StackNode head = new StackNode(0);

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 用尾插法push
     *
     * @param val
     */
    public void push(int val) {
        StackNode node = new StackNode(val);
        node.next = head.next;
        head.next = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        StackNode current = head;
        int value = current.next.val;
        current.next = current.next.next;
        return value;
    }
}

class StackNode {
    /**
     * 数据域
     */
    int val;
    /**
     * 指针域
     */
    StackNode next;

    public StackNode() {
    }

    public StackNode(int val) {
        this.val = val;
    }
}
