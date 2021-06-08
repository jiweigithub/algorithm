package com.hanshunping.designpattern.factory.method;

import com.hanshunping.designpattern.factory.entity.Car;
import com.hanshunping.designpattern.factory.entity.DaZhong;

public class DazhongFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new DaZhong();
    }
}
