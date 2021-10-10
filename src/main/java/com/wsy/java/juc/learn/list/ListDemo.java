package com.wsy.java.juc.learn.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main (String[] args) {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        LinkedList<String> linkedList = new LinkedList<>();
        Vector vector = new Vector();
        Collections.synchronizedList(arrayList);
    }
}
