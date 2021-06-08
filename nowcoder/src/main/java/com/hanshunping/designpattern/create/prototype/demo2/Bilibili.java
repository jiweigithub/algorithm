package com.hanshunping.designpattern.create.prototype.demo2;

import java.util.Date;

/**
 * 客户端
 */
public class Bilibili {
    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象
        Date date = new Date();
        Video v1 = new Video("狂神说JAVA", date);
        //v1克隆v2
        Video v2 = (Video) v1.clone();
        System.out.println("v1=>" + v1);
        System.out.println("v2=>" + v2);
        System.out.println("================================================");
        date.setTime(2233333);

        System.out.println("v1=>" + v1);
        System.out.println("v2=>" + v2);


//        System.out.println("v1=>hash:" + v1.hashCode());
//        System.out.println("v2=>hash:" + v2.hashCode());


//        v2.setName("克隆狂神说JAVA");
//        System.out.println("v2=>" + v2);


    }
}
