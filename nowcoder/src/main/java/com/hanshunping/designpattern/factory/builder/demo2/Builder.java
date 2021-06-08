package com.hanshunping.designpattern.factory.builder.demo2;

public abstract class Builder {

    abstract Builder buildA(String msg);

    abstract Builder buildB(String msg);

    abstract Builder buildC(String msg);

    abstract Builder buildD(String msg);

    abstract Product getProduct();
}
