package com.hanshunping.jvm;

public class NativeDemo {
    public static void main(String[] args) {
        new Thread(()->{

        },"AA").start();
    }
    //native: 凡是带了native类关键字的，说明Java的作用范围达不到了，会去调用底层C语言的库！
    //会进入本地方法栈，调用JNI接口（本地方法接口）
    //JNI的作用，扩展Java的使用，融合不同的编程语言为Java所用！最初：c,c++
    //在内存区域中，专门开辟了一块标记区域，即本地方法栈，登记Native方
    //在最终执行的时候，去加载本地方法库中的方法通过JNI
    private native void start0();

    //调用其他接口：
}
