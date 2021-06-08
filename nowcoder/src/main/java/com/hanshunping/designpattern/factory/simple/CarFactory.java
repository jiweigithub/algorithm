package com.hanshunping.designpattern.factory.simple;

import com.hanshunping.designpattern.factory.entity.Car;
import com.hanshunping.designpattern.factory.entity.Tesla;
import com.hanshunping.designpattern.factory.entity.WuLing;

/**
 * 简单工厂模式（静态工厂模式）
 * 缺点：增加一个新的产品，如果不修改代码，就无法实现
 */
public class CarFactory {
    //方法一
    public static Car getCar(String car) {
        if (car.equals("五菱")) {
            return new WuLing();
        } else if (car.equals("特斯拉")) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
