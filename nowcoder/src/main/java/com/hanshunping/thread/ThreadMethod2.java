package com.hanshunping.thread;

public class ThreadMethod2 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.setName("一个子线程");
        t2.start();
        new Thread(()->{
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        },"另一个子线程").start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if (i == 5) {
                System.out.println(Thread.currentThread().getName() + "让子线程先执行");
                t2.join();
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
