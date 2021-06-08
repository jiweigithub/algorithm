package com.hanshunping.designpattern.create.principle.isp;

public class ISPDemo2 {

    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.depend1(new B1());
        a1.depend2(new B1());
        a1.depend3(new B1());//A1类通过接口依赖B1
        C1 c1 = new C1();
        c1.depend1(new D1());
        c1.depend4(new D1());
        c1.depend5(new D1());//C1类通过接口依赖D1
    }

}

interface MyInterface1 {
    void method1();
}

interface MyInterface2 {
    void method2();

    void method3();

}

interface MyInterface3 {
    void method4();

    void method5();

}

class B1 implements MyInterface1, MyInterface2 {

    @Override
    public void method1() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method2() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method3() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }
}

class D1 implements MyInterface1, MyInterface3 {

    @Override
    public void method1() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method4() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void method5() {
        System.out.println(this.getClass().getName() + "\t执行了\t" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }
}

class A1 {


    public void depend1(MyInterface1 b) {
        b.method1();
    }

    public void depend2(MyInterface2 b) {
        b.method2();
    }

    public void depend3(MyInterface2 b) {
        b.method3();
    }

}

class C1 {
    public void depend1(MyInterface1 c) {
        c.method1();
    }

    public void depend4(MyInterface3 c) {
        c.method4();
    }

    public void depend5(MyInterface3 c) {
        c.method5();
    }
}
