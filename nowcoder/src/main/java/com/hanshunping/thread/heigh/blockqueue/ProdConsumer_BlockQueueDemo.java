package com.hanshunping.thread.heigh.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ShareResource {

    private volatile boolean FLAG = true; //默认开启，进行生产+消费

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public ShareResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws Exception {
        String data = null;
        boolean retValue = false;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2l, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t插入队列\t" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列\t" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t大老板叫停了，表示FLAG==false，生产动作结束");
    }

    public void consumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2l, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t超过2秒钟没有取到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列蛋糕\t" + result + "成功");
        }
    }

    public void stop() throws Exception {
        this.FLAG = false;
    }

}

/**
 * 基于阻塞队列的生产者消费者模式
 * <p>
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程,启动");
            try {
                shareResource.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程,启动");
            System.out.println();
            System.out.println();
            try {
                shareResource.consumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到，大老板main线程叫停，活动结束");
        try {
            shareResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
