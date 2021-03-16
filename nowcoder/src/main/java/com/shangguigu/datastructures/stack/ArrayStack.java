package com.shangguigu.datastructures.stack;

import java.util.Scanner;

/**
 * 栈
 * 实现栈的思路分析：
 * 1.使用数组来模拟栈
 * 2.定义一个变量top来表示栈顶，初始化为-1
 * 3.入栈的操作，当有数据加入到栈的时候，top++，stack[top] = data;
 * 4.出栈的操作，int value = stack[top]; top--, return value
 */
public class ArrayStack {

    public static void main(String[] args) {
        //创建一个ArrayStack的对象
        ArrayStack stack = new ArrayStack(5);
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

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组模拟栈，数据放在该数组中
     */
    private int[] stack;

    /**
     * 栈顶指针，初始化为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return top + 1;
    }
}
