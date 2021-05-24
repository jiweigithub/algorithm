package com.hanshunping.thread.heigh.volatile_;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 * <p>
 * 验证volatile的可见性
 * 1.1假如number = 0; 未被volatitle修饰，没有可见性;
 * 1.2通过使用volatile修饰 number属性，可以解决可见性问题;
 * 验证volatile不保证原子性
 * 2.1原子性是什么？
 * 不可分割，完整性，即某个线程在做具体业务的时，中间不可被加塞或者被分割。
 * 需要整体完整，要么同时成功，要么同时失败。
 * 2.2
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.add2();
                    myData.addAtomic();
                }
            }, "Thread-" + i).start();
        }
        while (Thread.activeCount() > 2) {

        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value：" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomic number value：" + myData.atomicInteger.get());
    }

    //volatile可以保证资源的可见性，保证每个线程的工作内存中，总是获取主内存中最新的值(MESI缓存一致性协议，总线嗅探机制)
    private static void seeOkByVolatile() {
        //资源对象
        MyData data = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.add();
            System.out.println(Thread.currentThread().getName() + "\t updated number value：" + data.number);
        }, "AAA").start();

        //第二个线程
        while (data.number == 0) {
            //main线程就一直等待循环，直到number值不再等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value：" + data.number);
    }
}

class MyData {
    volatile int number = 0;

    public void add() {
        this.number += 60;
    }

    public void add2() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}