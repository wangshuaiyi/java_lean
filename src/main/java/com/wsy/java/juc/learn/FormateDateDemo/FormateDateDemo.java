package com.wsy.java.juc.learn.FormateDateDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FormateDateDemo {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        protected DateFormat initiallValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }

    };
}
