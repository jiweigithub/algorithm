package com.hanshunping.generic;

public class GenericDemo {

    public static void main(String[] args) {
        Bukect<Apple> bukect0 = new Bukect<>(new RedApple());
        bukect0.setV(new RedApple());
        Bukect<? extends Apple> bukect = new Bukect<>(new RedApple());
        Apple v = bukect.getV();
        RedApple a = new RedApple();
        Bukect<? super Apple> bukect1 = new Bukect<>(new Fruit());
        bukect1.setV(new RedApple());
        Object v1 = bukect1.getV();
        System.out.println(v1);
    }
}

