package com.hanshunping.thread.heigh.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t come in" + System.currentTimeMillis());
            LockSupport.park();//当前线程等待...等待其他线程通知放行，需要许可证
            System.out.println(Thread.currentThread().getName() + "\t 被唤醒" + System.currentTimeMillis());
        }, "A");
        a.start();

        Thread b = new Thread(() -> {
            //唤醒A线程
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t 通知A线程");
        }, "B");
        b.start();

    }

    /**
     * lock的等待和唤醒
     */
    private static void lockAwaitAndSignal() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t 通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    /**
     * Object的wait和notify方法样例
     *
     * @param a
     * @param b
     */
    private static void synchronizedWaitAndNotify(int a, int b) {
        for (int i = 1; i <= a; i++) {
            threadWait("A" + i);
        }
        for (int i = 1; i <= b; i++) {
            threadNotify("B" + i);
        }
    }

    private static void threadNotify(String b) {
        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t 通知");
            }
        }, b).start();
    }

    private static void threadWait(String a) {
        new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
            }
        }, a).start();
    }

}
