package com.hanshunping.thread;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        System.out.println(t3.getName() + "状态：" + t3.getState());
        t3.start();
        while (Thread.State.TERMINATED != t3.getState()) {
            System.out.println(t3.getName() + "状态：" + t3.getState());
            Thread.sleep(500);
        }
        System.out.println(t3.getName() + "状态：" + t3.getState());
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
