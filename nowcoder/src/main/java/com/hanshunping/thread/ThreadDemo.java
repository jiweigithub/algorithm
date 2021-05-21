package com.hanshunping.thread;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        Thread dogThread = new Thread(dog);
        Cat cat = new Cat();
        cat.start();
        dogThread.start();
    }


}


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