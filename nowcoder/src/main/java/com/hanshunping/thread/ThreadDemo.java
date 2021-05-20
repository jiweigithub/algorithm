package com.hanshunping.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }


}


class Cat extends Thread {
    int times;

    @Override
    public void run() {
        while (times < 8) {
            try {
                System.out.println("喵~~~" + (++times));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}