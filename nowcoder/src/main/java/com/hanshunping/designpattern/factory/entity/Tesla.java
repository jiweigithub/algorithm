package com.hanshunping.designpattern.factory.entity;

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
