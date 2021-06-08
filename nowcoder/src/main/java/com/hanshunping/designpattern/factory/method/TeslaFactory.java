package com.hanshunping.designpattern.factory.method;

import com.hanshunping.designpattern.factory.entity.Car;
import com.hanshunping.designpattern.factory.entity.Tesla;

public class TeslaFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
