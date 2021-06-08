package com.hanshunping.designpattern.create.builder.demo1;

/**
 * 抽象的建造者
 */
public abstract class Builder {

    abstract void buildA();

    abstract void buildB();

    abstract void buildC();

    abstract void buildD();

    abstract House getHouse();
}
