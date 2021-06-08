package com.hanshunping.designpattern.struct.adapter;

public class Adapter2 implements Net2Usb {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
