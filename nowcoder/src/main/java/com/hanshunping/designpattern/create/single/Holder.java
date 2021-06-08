package com.hanshunping.designpattern.create.single;

/**
 * 静态内部类实现 线程安全
 */
public class Holder {

    private Holder() {
    }

    public static Holder getInstance() {
        return InnerClass.holder;
    }

    public static class InnerClass {
        private static final Holder holder = new Holder();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Holder instance = Holder.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
