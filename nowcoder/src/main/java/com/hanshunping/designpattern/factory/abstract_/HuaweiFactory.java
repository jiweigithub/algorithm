package com.hanshunping.designpattern.factory.abstract_;

public class HuaweiFactory implements IFactory {
    @Override
    public Phone productPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Router productRouter() {
        return new HuaweiRouter();
    }
}
