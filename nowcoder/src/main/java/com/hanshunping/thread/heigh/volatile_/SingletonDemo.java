package com.hanshunping.thread.heigh.volatile_;

/**
 * 单例模式
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法SingletonDemo()");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    //DLC模式 (Double Check Lock 双端检锁机制)
    public static SingletonDemo syncGetInstance2() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程下单例模式
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        //并发多线程后，情况发生了很大的变化
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.syncGetInstance2();
            }, String.valueOf(i)).start();
        }
    }
}
