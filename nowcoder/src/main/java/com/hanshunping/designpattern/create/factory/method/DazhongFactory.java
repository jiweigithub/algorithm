package com.hanshunping.designpattern.create.factory.method;

import com.hanshunping.designpattern.create.factory.entity.Car;
import com.hanshunping.designpattern.create.factory.entity.DaZhong;

public class DazhongFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new DaZhong();
    }
}
