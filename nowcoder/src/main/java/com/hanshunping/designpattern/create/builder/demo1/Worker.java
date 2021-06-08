package com.hanshunping.designpattern.create.builder.demo1;

public class Worker extends Builder {

    private House house;

    public Worker() {
        this.house = new House();
    }

    @Override
    void buildA() {
        System.out.println("地基");
        house.setBuildA("地基");
    }

    @Override
    void buildB() {
        System.out.println("钢筋工程");
        house.setBuildB("钢筋工程");
    }

    @Override
    void buildC() {
        System.out.println("铺设电线");

        house.setBuildC("铺设电线");
    }

    @Override
    void buildD() {
        System.out.println("粉刷");

        house.setBuildD("粉刷");
    }

    @Override
    House getHouse() {
        return house;
    }
}
