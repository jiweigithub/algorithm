package com.hanshunping.designpattern.create.factory.abstract_;

public class MiFactory implements IFactory {
    @Override
    public Phone productPhone() {
        return new MiPhone();
    }

    @Override
    public Router productRouter() {
        return new MiRouter();
    }
}
