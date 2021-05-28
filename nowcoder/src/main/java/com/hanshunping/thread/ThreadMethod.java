package com.hanshunping.thread;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("纪委");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread.sleep(10 * 1000);

        t1.interrupt();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子~~~" + i);
            }

            try {
                Thread.sleep(20 * 1000);
                System.out.println(Thread.currentThread().getName() + "休眠中~~~");
            } catch (InterruptedException e) {
                //当线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException 是捕获到的一个异常
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
                break;
            }
        }

    }
}
