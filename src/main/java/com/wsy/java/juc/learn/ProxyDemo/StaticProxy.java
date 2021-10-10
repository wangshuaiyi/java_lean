package com.wsy.java.juc.learn.ProxyDemo;

public class StaticProxy implements Animal{

    private Animal animal;

    public StaticProxy (Animal animal) {
        this.animal = animal;
    }

    @Override
    public void action () {
        System.out.println("代理开始");
        animal.action();
        System.out.println("代理结束");
    }

    @Override
    public void eat () {
        System.out.println("代理开始");
        animal.eat();
        System.out.println("代理结束");
    }
}
