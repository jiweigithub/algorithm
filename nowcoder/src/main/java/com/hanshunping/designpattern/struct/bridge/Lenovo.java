package com.hanshunping.designpattern.struct.bridge;

/**
 * 联想品牌
 */
public class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.println("联想");
    }
}
