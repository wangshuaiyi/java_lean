package com.wsy.java.juc.learn.ProxyDemo;

public class Cat implements Animal {
    @Override
    public void action () {
        System.out.println("喵喵喵");
    }

    @Override
    public void eat () {
        System.out.println("吃鱼");
    }
}
