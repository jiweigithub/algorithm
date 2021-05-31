package com.hanshunping.thread.heigh.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //带入一个银行办理业务的案例来模拟我们AQS如果进行线程的管理和通知唤醒机制；
        System.out.println("银行开张了");
        //三个线程模拟三个银行网点，受理窗口办理业务的顾客

        //第1个顾客
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "Thread-A").start();
        //第2个顾客 ,由于受理业务的窗口只有一个，只有一个线程能持有锁，B只能等待；
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
            } finally {
                lock.unlock();
            }
        }, "Thread-B").start();

        //第3个顾客 ,由于受理业务的窗口只有一个，只有一个线程能持有锁，B只能等待；
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
            } finally {
                lock.unlock();
            }
        }, "Thread-C").start();
    }
}
