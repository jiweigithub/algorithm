package com.hanshunping.thread;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("主线程执行中~~~");
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护线程守护中~~~~");
        }
    }
}
