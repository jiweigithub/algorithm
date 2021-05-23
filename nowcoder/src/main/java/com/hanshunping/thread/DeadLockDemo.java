package com.hanshunping.thread;

public class DeadLockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();

        Object lock2 = new Object();
        T4 t41 = new T4(lock1, lock2, true);
        t41.setName("Thread-t41");
        T4 t42 = new T4(lock1, lock2, false);
        t42.setName("Thread-t42");
        t41.start();
        t42.start();
    }
}

class T4 extends Thread {

    private Object lock1;

    private Object lock2;

    boolean flag;

    public T4(Object lock1, Object lock2, boolean flag) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            f1();
        } else {
            f2();
        }
    }

    private void f1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "进入1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "进入2");
            }
        }
    }

    private void f2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "进入3");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "进入4");
            }
        }
    }
}
