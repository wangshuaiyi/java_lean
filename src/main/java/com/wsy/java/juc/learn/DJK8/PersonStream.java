package com.wsy.java.juc.learn.DJK8;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonStream {
    private String name;
    private int age;

    public PersonStream (String name, int age) {
        this.name = name;
        this.age = age;
    }
}
