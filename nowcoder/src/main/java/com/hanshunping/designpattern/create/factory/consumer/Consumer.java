package com.hanshunping.designpattern.create.factory.consumer;

import com.hanshunping.designpattern.create.factory.entity.Car;
import com.hanshunping.designpattern.create.factory.method.DazhongFactory;
import com.hanshunping.designpattern.create.factory.method.TeslaFactory;
import com.hanshunping.designpattern.create.factory.method.WulingFactory;

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
