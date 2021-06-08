package com.hanshunping.designpattern.create.factory.method;

import com.hanshunping.designpattern.create.factory.entity.Car;
import com.hanshunping.designpattern.create.factory.entity.WuLing;

public class WulingFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
