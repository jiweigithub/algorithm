package com.hanshunping.designpattern.factory.consumer;

import com.hanshunping.designpattern.factory.entity.Car;
import com.hanshunping.designpattern.factory.method.DazhongFactory;
import com.hanshunping.designpattern.factory.method.TeslaFactory;
import com.hanshunping.designpattern.factory.method.WulingFactory;
import com.hanshunping.designpattern.factory.simple.CarFactory;

public class Consumer {
    public static void main(String[] args) {
//        Car car1 = new WuLing();
//        Car car2 = new Tesla();
//        car1.name();
//        car2.name();
        //简单工厂模式
//        Car car = CarFactory.getCar("五菱");
//        Car tesla = CarFactory.getCar("特斯拉");
//        car.name();
//        tesla.name();
        //工厂方法模式
        Car car1 = new WulingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        Car car3 = new DazhongFactory().getCar();
        car1.name();
        car2.name();
        car3.name();
    }
}
