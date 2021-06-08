package com.hanshunping.designpattern.create.builder.demo1;

/**
 * 指挥者（负责指挥构建一个工程，工程如何让构建，由它决定）
 */
public class Director {

    //指挥工人按照步骤建房子
    public House build(Builder builder) {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getHouse();
    }

}
