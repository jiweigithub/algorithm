package com.hanshunping.generic;


public class Bukect<V> {
    V v;

    public Bukect(V v) {
        this.v = v;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
