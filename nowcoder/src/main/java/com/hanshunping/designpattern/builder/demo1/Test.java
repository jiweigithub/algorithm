package com.hanshunping.designpattern.builder.demo1;

public class Test {
    public static void main(String[] args) {
        //指挥者
        Director director = new Director();
        //指挥具体的工人
        House build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
