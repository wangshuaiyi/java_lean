package com.wsy.java.juc.learn.QueueDemo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayPerson implements Delayed {
    private String name;
    private int age;
    private long delay;
    private long expire;

    public DelayPerson(String name, int age,long delay) {
        this.name = name;
        this.age = age;
        this.delay = delay;
        this.expire = System.currentTimeMillis() + this.delay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @Override
    public long getDelay (TimeUnit unit) {
        return unit.convert( this.expire - System.currentTimeMillis(),TimeUnit.MILLISECONDS );
    }

    @Override
    public int compareTo (Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS ) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
