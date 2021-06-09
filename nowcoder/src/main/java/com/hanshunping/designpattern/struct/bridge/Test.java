package com.hanshunping.designpattern.struct.bridge;

public class Test {

    public static void main(String[] args) {
        Computer computer = new LapTop(new Apple());
        computer.info();
        Computer computer1 = new DeskTop(new Lenovo());
        computer1.info();
    }

}
