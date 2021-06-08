package com.hanshunping.designpattern.struct.adapter;

/**
 * 真正的适配器，需要连接USB，连接网线
 */
public class Adapter extends Adaptee implements Net2Usb {

    @Override
    public void handleRequest() {
        super.request();
    }
}
