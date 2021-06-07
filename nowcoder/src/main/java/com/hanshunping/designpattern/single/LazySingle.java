package com.hanshunping.designpattern.single;

/**
 * 懒汉单例（线程不安全）
 * <p>
 * 道高一尺魔高一仗
 */
public class LazySingle {

    private LazySingle() {
        synchronized (LazySingle.class) {
            if (lazySingle != null) {
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t进入构造");
    }

    private volatile static LazySingle lazySingle;

    /**
     * 单线程情况下，OK,多线程情况下会出现问题
     *
     * @return
     */
    public static LazySingle getInstance() {
        //双重检测锁模式，懒汉式单例，DCL懒汉式
        if (lazySingle == null) {
            synchronized (LazySingle.class) {
                if (lazySingle == null) {
                    //不是一个原子性操作
                    lazySingle = new LazySingle();
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazySingle;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                LazySingle instance = LazySingle.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
