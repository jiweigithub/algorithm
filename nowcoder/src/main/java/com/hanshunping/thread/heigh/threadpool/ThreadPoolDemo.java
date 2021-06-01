package com.hanshunping.thread.heigh.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //Executor,Executors

        //一个线程池，5个处理线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池一线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池可扩容线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
