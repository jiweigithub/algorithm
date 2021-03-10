package com.shangguigu.datastructures.queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueue {
    /**
     * 表示队列的最大容量
     */
    private int maxSize;
    /**
     * 队列存储数据的数组
     */
    private int[] array;
    /**
     * 指向队列头的前一个位置(不包含头)
     */
    private int front;
    /**
     * 指向队列尾（包含尾）
     */
    private int rear;

    /**
     * 构造器
     *
     * @param arrayMaxSize 队列最大容量
     */
    public ArrayQueue(int arrayMaxSize) {
        this.maxSize = arrayMaxSize;
        this.array = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向队列添加数据
     *
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满，不能加入数据!");
        }
        //尾指针后移
        this.rear++;
        array[rear] = n;
    }

    /**
     * 从队列中取数据
     *
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空，不能获取数据");
        }
        this.front++;
        return array[front];
    }

    /**
     * 显示队列所有数据
     */
    public void listQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = this.front+1; i < rear+1; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    /**
     * 显示队列的头数据
     */
    public int queueHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有头数据!");
        }
        return array[front + 1];
    }

    public static void main(String[] args) {
        //测试数组模拟队列

        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接受用户输入
        char key = ' ';

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("l(list)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'l':
                    arrayQueue.listQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int val = scanner.nextInt();
                    try{
                        arrayQueue.addQueue(val);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.queueHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
