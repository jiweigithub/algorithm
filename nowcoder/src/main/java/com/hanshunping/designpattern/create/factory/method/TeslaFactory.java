package com.hanshunping.designpattern.create.factory.method;

import com.hanshunping.designpattern.create.factory.entity.Car;
import com.hanshunping.designpattern.create.factory.entity.Tesla;

public class TeslaFactory implements ICarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
