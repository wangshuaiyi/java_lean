package com.wsy.java.juc.learn.ProxyDemo;

public class SubjectImpl implements Subject {
    @Override
    public void hello (String param) {
        System.out.println("hello :" + param);
    }
}
