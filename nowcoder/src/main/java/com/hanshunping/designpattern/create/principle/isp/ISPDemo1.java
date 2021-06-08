package com.hanshunping.designpattern.create.principle.isp;

/**
 * 接口隔离原则
 */
public class ISPDemo1 {
}


interface MyInterface {
    void method1();

    void method2();

    void method3();

    void method4();

    void method5();
}

class B implements MyInterface {

    @Override
    public void method1() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void method2() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method3() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method4() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method5() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }
}

class D implements MyInterface {

    @Override
    public void method1() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void method2() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method3() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method4() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method5() {
        System.out.println(this.getClass().getName() + "\t执行了" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }
}

/**
 * A 类通过Interface1 依赖 B 类，但是只会用到1，2，3方法
 */
class A {

    public void depend1(MyInterface b) {
        b.method1();
    }

    public void depend2(MyInterface b) {
        b.method2();
    }

    public void depend3(MyInterface b) {
        b.method3();
    }
}

/**
 * C 类通过Interface1 依赖 D 类，但是只会用到1，4，5方法
 */
class C {

    public void depend1(MyInterface d) {
        d.method1();
    }

    public void depend4(MyInterface d) {
        d.method4();
    }

    public void depend5(MyInterface d) {
        d.method5();
    }
}
