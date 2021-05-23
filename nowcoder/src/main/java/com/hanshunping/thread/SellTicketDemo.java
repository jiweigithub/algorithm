package com.hanshunping.thread;

public class SellTicketDemo {


    public static void main(String[] args) {

        SellTicket03 sellTicket03 = new SellTicket03();
        Thread thread1 = new Thread(sellTicket03);
        Thread thread2 = new Thread(sellTicket03);
        Thread thread3 = new Thread(sellTicket03);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
        //        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        SellTicket01 sellTicket04 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
//        sellTicket04.start();
//        SellTicket02 sellTicket02 = new SellTicket02();
//        Thread thread1 = new Thread(sellTicket02);
//        Thread thread2 = new Thread(sellTicket02);
//        Thread thread3 = new Thread(sellTicket02);
//        Thread thread4 = new Thread(sellTicket02);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
    }

}

/**
 * 实现接口方式，使用synchronized实现线程同步
 */
class SellTicket03 implements Runnable {

    private int ticketNum = 1000;

    private boolean loop = true;

    private Object lock = new Object();

    @Override
    public void run() {
        while (loop) {
            sell2();
        }
    }

    /**
     * 同步方法，在同一时刻，只能有一个线程来执行sell方法
     * 此时锁是加在this上的
     */
    private synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("票卖完了");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
            System.out.println("窗口："
                    + Thread.currentThread().getName() + "售出一张表，剩余票数" + (--ticketNum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sell2() {
        //锁加在对象上
        synchronized (lock) {
            if (ticketNum <= 0) {
                System.out.println("票卖完了");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
                System.out.println("窗口："
                        + Thread.currentThread().getName() + "售出一张表，剩余票数" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SellTicket01 extends Thread {
    //让多个线程共享num
    public static int num = 100;

    private int sellCount = 0;

    @Override
    public void run() {
        while (num > 0) {
            try {
                Thread.sleep(50);
                System.out.println("窗口："
                        + Thread.currentThread().getName() + "售出一张表，剩余票数" + (--num) + "已售出：" + (++sellCount));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("票卖完了");
    }
}

class SellTicket02 implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (ticketNum > 0) {
            try {
                Thread.sleep(50);
                System.out.println("窗口："
                        + Thread.currentThread().getName() + "售出一张表，剩余票数" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("票卖完了");
    }
}


