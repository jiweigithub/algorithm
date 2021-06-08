package com.hanshunping.designpattern.factory.abstract_;

public class HuaweiPhone implements Phone {
    @Override
    public void powerOn() {
        System.out.println("华为手机开机");
    }

    @Override
    public void powerOff() {
        System.out.println("华为手机关机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发短信");
    }
}
