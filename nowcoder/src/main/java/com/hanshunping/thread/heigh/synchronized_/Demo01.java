package com.hanshunping.thread.heigh.synchronized_;

public class Demo01 {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();
        thread.start();
        thread2.start();
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "\t进入同步代码块1");
            synchronized (this) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "\t进入同步代码块2");
            }
        }
    }
}