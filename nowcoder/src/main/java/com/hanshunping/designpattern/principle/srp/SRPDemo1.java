package com.hanshunping.designpattern.principle.srp;

/**
 * 单一职责原则
 */
public class SRPDemo1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("小轿车");
        vehicle.run("飞机");
    }

}

/**
 * 交通工具类
 * 方式1
 * 1.在方式1 的run方法中，违反了单一职责原则
 * 2.解决方案非常简单，根据交通工具运行的方式不同，分解成不同的类即可
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "\t在公路上运行。。。");
    }
}

