package com.hanshunping.thread.heigh.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者，消费者传统版
 * <p>
 * 一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 * <p>
 * 大前提：高内聚    低耦合
 * 1.线程     操作（方法）      资源类
 * 2.判断     干活              通知
 * 3.严防虚假唤醒
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();


        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}

/**
 * 资源类
 */
class ShareData {

    private int num = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            //3.严防虚假唤醒
            while (num != 0) {
                //等待，不能生产
                condition.await();
            }
            //2.干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3.通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            //3.严防虚假唤醒
            while (num == 0) {
                //等待，不能消费了
                condition.await();
            }
            //2.干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3.通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}



