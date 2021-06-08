package com.hanshunping.designpattern.factory.builder.demo2;

public class Test {

    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();
        //链式编程，在原有的基础上自由组合，如果不组合，也有默认的
        Product product = worker
                .buildA("全家桶")
                .buildB("雪碧")
                .getProduct();
        System.out.println(product.toString());
    }

}
