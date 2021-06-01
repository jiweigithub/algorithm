package com.hanshunping.thread.heigh.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        Thread t1 = new Thread(futureTask, "AAA");
//        Thread t2 = new Thread(futureTask, "BBB");
        t1.start();
        Integer integer = futureTask.get();
        System.out.println(integer);
        System.out.println("主线程执行完毕");
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t执行了");
        TimeUnit.SECONDS.sleep(10);
        return 1024;
    }
}
