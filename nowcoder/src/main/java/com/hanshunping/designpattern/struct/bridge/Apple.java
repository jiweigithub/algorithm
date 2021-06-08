package com.hanshunping.designpattern.struct.bridge;

/**
 * 苹果品牌
 */
public class Apple implements Brand {
    @Override
    public void info() {
        System.out.println("苹果");
    }
}
