package com.hanshunping.designpattern.struct.proxy.demo4;

import com.hanshunping.designpattern.struct.proxy.demo2.UserService;
import com.hanshunping.designpattern.struct.proxy.demo2.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.query();
    }

}
