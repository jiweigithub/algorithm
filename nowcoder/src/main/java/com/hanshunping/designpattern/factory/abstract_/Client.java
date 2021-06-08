package com.hanshunping.designpattern.factory.abstract_;

public class Client {
    public static void main(String[] args) {
        IFactory iFactory1 = new MiFactory();
        IFactory iFactory2 = new HuaweiFactory();
        Phone phone = iFactory1.productPhone();
        Router router = iFactory1.productRouter();
        Phone phone1 = iFactory2.productPhone();
        Router router1 = iFactory2.productRouter();
        phone.powerOn();
        phone.sendSMS();
        router.powerOn();
        router.openWifi();
        phone1.powerOn();
        phone1.sendSMS();
        router1.powerOn();
        router1.openWifi();
    }
}
