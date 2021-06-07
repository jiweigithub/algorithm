package com.hanshunping.jvm;

public class Demo01 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("max=" + maxMemory + "字节\t" + maxMemory / 1024.0 / 1024 + "MB");
        System.out.println("total=" + maxMemory + "字节\t" + totalMemory / 1024.0 / 1024 + "MB");
    }
}
