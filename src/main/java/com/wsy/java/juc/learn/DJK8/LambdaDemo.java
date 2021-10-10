package com.wsy.java.juc.learn.DJK8;

import java.util.function.Function;

public class LambdaDemo {
    public static void main (String[] args) {
        MyFunctionalInterface myFunctionalInterface1 = ()-> System.out.println("add");
        MyFunctionalInterface2 myFunctionalInterface2 = (i,j)-> i+j;

        MyFunctionalInterface myFunctionalInterface3 = () -> LambdaDemo.getStaticMethod();
        myFunctionalInterface3.add();

        // 使用方法引入调用方法 必须满足：方法引入的方法必须和函数接口中的方法参数列表/返回值一定保持一致。
        MyFunctionalInterface myFunctionalInterface4 = LambdaDemo::getStaticMethod;


        Function<String,Integer> function = String::length;
        Function<String,Integer> function1 = (str)->str.length();

        LambdaDemo demo = new LambdaDemo();
        MyFunctionalInterface myFunctionalInterface5 = demo::getPublicMethod;

        PersionInterface peronLambdDemo = PeronLambdDemo::new;





    }
    public void getPublicMethod(){
        System.out.println("asd");
    }
    public static void getStaticMethod() {
        System.out.println("我是 getMethod");
    }

}

