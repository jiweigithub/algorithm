package com.hanshunping.designpattern.create.factory.abstract_;

public class MiRouter implements Router {
    @Override
    public void powerOn() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void powerOff() {
        System.out.println("小米路由器关机");
    }

    @Override
    public void openWifi() {
        System.out.println("小米路由器打开Wifi");
    }

    @Override
    public void settingNet() {
        System.out.println("小米路由器设置网络");
    }
}
