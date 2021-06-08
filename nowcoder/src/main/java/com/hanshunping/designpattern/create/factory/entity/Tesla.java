package com.hanshunping.designpattern.create.factory.entity;

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
