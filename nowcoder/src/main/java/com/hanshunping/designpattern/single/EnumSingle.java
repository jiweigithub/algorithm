package com.hanshunping.designpattern.single;

//enum 本身也是一个class类
public enum EnumSingle {

    INSTANCE;

    public static EnumSingle getInstance() {
        return INSTANCE;
    }

}

class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                EnumSingle instance = EnumSingle.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
