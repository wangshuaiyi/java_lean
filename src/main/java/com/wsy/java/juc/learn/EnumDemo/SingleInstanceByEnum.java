package com.wsy.java.juc.learn.EnumDemo;

public class SingleInstanceByEnum {
}

enum SomeThing{
    INSTANCE;
    private SingleInstanceByEnum instance;
    SomeThing(){
        instance = new SingleInstanceByEnum();
    }
    public SingleInstanceByEnum getInstance(){
        return instance;
    }


}

