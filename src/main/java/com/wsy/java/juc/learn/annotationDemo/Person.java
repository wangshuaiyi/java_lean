package com.wsy.java.juc.learn.annotationDemo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    @MyAnno
    private String stra;
    private String strb;
    private String strc;

    public Person (String stra, String strb, String strc) {
        super();
        this.stra = stra;
        this.strb = strb;
        this.strc = strc;
    }


}
