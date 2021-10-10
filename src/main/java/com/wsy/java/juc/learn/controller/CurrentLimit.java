package com.wsy.java.juc.learn.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentLimit {

    /**
     * name 限流的名字
     * @return
     */
   String name() default "";

    /**
     * 每秒访问的次数
     * @return
     */
   double token() default 20;
}
