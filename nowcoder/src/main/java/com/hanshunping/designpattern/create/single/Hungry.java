package com.hanshunping.designpattern.create.single;

/**
 * 单例模式 饿汉式(线程安全) 可能会浪费空间
 */
public class Hungry {

    private Hungry() {
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Hungry instance = Hungry.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
