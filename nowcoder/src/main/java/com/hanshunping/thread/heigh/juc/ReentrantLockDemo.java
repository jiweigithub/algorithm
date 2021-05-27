package com.hanshunping.thread.heigh.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t3").start();

        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t4").start();
    }
}

class Phone {

    ReentrantLock lock = new ReentrantLock();

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t --->invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ----->invoked sendEmail()");
    }

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t --->invoked get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ----->invoked set()");
        } finally {
            lock.unlock();
        }
    }
}
