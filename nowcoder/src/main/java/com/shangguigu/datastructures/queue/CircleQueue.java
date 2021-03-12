package com.shangguigu.datastructures.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头，指向队列的第一个元素
     */
    private int front;

    /**
     * 队列尾的后一个位置，指向队列最后一个元素的后一个位置
     */
    private int rear;

    /**
     * 数组，用于存放数据，模拟队列
     */
    private int[] array;

    /**
     * 构造器
     *
     * @param maxSize
     */
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    /**
     * 判断队列是否空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        array[rear] = n;
        //将rear后移一位
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据或数据出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //1、先把front对应的值保存到一个临时变量
        //2、将front后移,考虑取模---->front=(front+1)%maxSize
        //3、返回临时保存的变量
        int res = array[front];
        array[front] = -1;
        front = (front + 1) % maxSize;
        return res;
    }

    //显示队列所有数据
    public void showQueue() {
        System.out.printf("数组内数据\n");
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
        if (isEmpty()) {
            System.out.println("队列为空，没数据");
            return;
        }
        //从front开始遍历，遍历多少个元素
        System.out.printf("队列内信息\nfront=%d, rear=%d \n",front,rear);
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没数据");
        }
        return array[front];
    }


    public static void main(String[] args) {
        //测试数组模拟队列

        //环形队列需要预留一个空间来移动指针，当maxSize=4时，可用空间为3
        CircleQueue arrayQueue = new CircleQueue(4);
        //接受用户输入
        char key = ' ';

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int val = scanner.nextInt();
                    try {
                        arrayQueue.addQueue(val);
                    } catch (Exception e) {
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
                        int res = arrayQueue.headQueue();
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
