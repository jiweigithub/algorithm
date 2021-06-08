package com.hanshunping.designpattern.create.principle.srp;

public class SRPDemo2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        roadVehicle.run("汽车");
        roadVehicle.run("摩托车");
        airVehicle.run("飞机");
        waterVehicle.run("潜艇");
    }

}

//方案2分析
//1.遵守单一职责原则
//2.但是这样做改动很大，即将类分解，同时修改客户端
//3.改进：直接修改Vehicle类，改动的代码会比较少 => 方案3

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "\t在公路上跑。。。");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "\t在天上飞。。。");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "\t在水里游。。。");
    }
}
