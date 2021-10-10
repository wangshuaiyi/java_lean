package com.wsy.java.juc.learn.stackDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈又称堆栈。只能在一段插入和删除。先进后厨的原理。
 */
public class StackLearn {

    private List list = new ArrayList();
    private int size = 0;


    public void push(Object o){
        list.add(o);
        size++;
    }
    public Object poll(){
        if(size == 0 ){
            return null;
        }
        Object o = list.get(size-1);
        size--;
        return o;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
}
