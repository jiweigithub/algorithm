package com.hanshunping.thread;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(10 * 1000);
        t.setLoop(false);
    }
}

class T implements Runnable {

    int count = 0;

    //设置一个控制变量
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
                System.out.println("T 运行中。。。" + (++count));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
