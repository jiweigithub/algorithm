package com.hanshunping.jvm;

import java.util.Random;


//-Xms2m -Xmx8m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
public class OOMDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");
        while (true) {
            stringBuilder.append(new Random().nextInt(999999999)).append(new Random().nextInt(999999999));
        }
    }
}
