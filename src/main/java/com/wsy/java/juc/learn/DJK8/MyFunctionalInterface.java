package com.wsy.java.juc.learn.DJK8;

@FunctionalInterface
public interface MyFunctionalInterface {
    void add();

    default void get(){
        System.out.println("get");
    }
    static  void demo(){
        System.out.println("static");
    }
}
