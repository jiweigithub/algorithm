package com.hanshunping.designpattern.principle.srp;

public class SRPDemo3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.fly("飞机");
        vehicle2.swimming("潜艇");
    }
}

/**
 * 方式3分析
 * 1.这种修改方法没有对原来的类做最大的修改，只是增加方法;
 * 2.这里虽然没有在类级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
 */
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "\t在公路上运行。。。");
    }

    public void fly(String vehicle) {
        System.out.println(vehicle + "\t在天上飞。。。");
    }

    public void swimming(String vehicle) {
        System.out.println(vehicle + "\t在水里游。。。");
    }
}


