package com.hanshunping.designpattern.factory.method;

import com.hanshunping.designpattern.factory.entity.Car;
import com.hanshunping.designpattern.factory.entity.WuLing;

public class WulingFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
