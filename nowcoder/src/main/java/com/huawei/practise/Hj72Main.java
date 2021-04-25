package com.huawei.practise;

/**
 * 百钱买百鸡
 */
public class Hj72Main{
    public static void main(String[] args){
        int x,y,z;
        for(x = 0; x < 15; x++){
            if((100 - 7 * x) % 4 == 0){
                y = (100 - 7 * x) / 4;
                z = 100 - x - y;
                System.out.println(x + " " + y + " " + z);
            }
        }
    }
}
