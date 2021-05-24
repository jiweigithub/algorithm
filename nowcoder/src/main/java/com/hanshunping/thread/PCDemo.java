package com.hanshunping.thread;

public class PCDemo {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}

//生产者--演员
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("快乐大本营播放中" + i);
            } else {
                this.tv.play("抖音：记录美好生活" + i);
            }
        }
    }
}

//消费者--观众
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            tv.watch();
        }
    }
}

//产品 节目
class TV {

    //演员表演的时候，观众等待
    //观众观看的时候，演员等待

    //表演的节目
    String voice;

    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了:" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}