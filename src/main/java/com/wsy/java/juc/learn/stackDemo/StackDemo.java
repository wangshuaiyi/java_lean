package com.wsy.java.juc.learn.stackDemo;

public class StackDemo {
    public static void main(String[] args){
        StackLearn stackLearn = new StackLearn();
        stackLearn.push("1");
        stackLearn.push("2");
        stackLearn.push("3");
        stackLearn.push("4");
        System.out.println(stackLearn.poll());
        System.out.println(stackLearn.poll());
        System.out.println(stackLearn.poll());
        System.out.println(stackLearn.poll());
        System.out.println(stackLearn.poll());
    }
}
