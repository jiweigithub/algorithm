package com.hanshunping.thread;

public class ProductorConsumerDemo {

    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();

        new Productor(syncContainer).start();
        new Consumer(syncContainer).start();
    }

}

/**
 * 生产者
 */
class Productor extends Thread {

    SyncContainer container;

    public Productor(SyncContainer syncContainer) {
        this.container = syncContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了--->" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了--->" + container.pop().id + "只鸡");
        }
    }
}

/**
 * 产品
 */
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

/**
 * 缓冲区
 */
class SyncContainer {

    Chicken[] chickens = new Chicken[10];

    int count;

    /**
     * 生产者放入产品
     *
     * @param chicken
     */
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者
        if (count == chickens.length) {
            //通知消费者消费,生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，放入产品
        chickens[count] = chicken;
        count++;
        //可以通知消费者消费了
        this.notifyAll();
    }

    /**
     * 消费者消费产品
     */
    public synchronized Chicken pop() {
        //判断能否消费
        if (count == 0) {
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}


