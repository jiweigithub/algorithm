package com.hanshunping.thread.heigh.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);



        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current value:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current value:" + atomicInteger.get());

        atomicInteger.getAndIncrement();
        atomicInteger.incrementAndGet();
    }

}
