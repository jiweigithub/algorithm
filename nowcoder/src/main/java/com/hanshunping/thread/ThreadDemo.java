package com.hanshunping.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bird bird = new Bird();
        FutureTask<String> futureTask = new FutureTask<>(bird);
        Thread birdThread = new Thread(futureTask);
        Dog dog = new Dog();
        Thread dogThread = new Thread(dog);
        Cat cat = new Cat();
        birdThread.start();
        cat.start();
        dogThread.start();
        String s = futureTask.get();
        System.out.println(s);
        System.out.println("主线程执行完毕");
    }


}

/**
 * 继承Thread类
 */
class Cat extends Thread {
    int times;

    @Override
    public void run() {
        while (times < 60) {
            try {
                System.out.println("喵喵喵~~~" + (++times) + "  线程名称：" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 实现Runnable接口
 */
class Dog implements Runnable {
    int times;

    @Override
    public void run() {
        while (times < 50) {
            try {
                System.out.println("汪汪汪~~~" + (++times) + "  线程名称：" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 实现Callable接口
 */
class Bird implements Callable<String> {

    private int step = 50;

    @Override
    public String call() throws Exception {
        while (step > 0) {
            System.out.println("我是小鸟，还剩" + (--step) + "米就飞到了");
            Thread.sleep(1000);
        }
        return "飞到了";
    }
}
