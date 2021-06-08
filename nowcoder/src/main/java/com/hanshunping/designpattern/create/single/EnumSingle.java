package com.hanshunping.designpattern.create.single;

//enum 本身也是一个class类
public enum EnumSingle {

    INSTANCE;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
