package com.wsy.java.juc.learn.DJK8;

public interface JDK8Interface {
    void addOrder();

    default void getDefaultOrder(){
        System.out.println("default function");
    }
    static void getStaticOrder(){
        System.out.println("static function");
    }
}
