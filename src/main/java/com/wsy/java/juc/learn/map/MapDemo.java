package com.wsy.java.juc.learn.map;

import com.wsy.java.juc.learn.Person;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class MapDemo {
    public static void main (String[] args) {
//        HashMap<String,String> hashMap = new HashMap<>();
//        Hashtable<String,String> hashtable = new Hashtable<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        System.out.println(concurrentHashMap);
        concurrentHashMap.put("a","a");
        concurrentHashMap.put("a1","a1");
        concurrentHashMap.size();
        System.out.println(concurrentHashMap.get("a"));
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a","a");
        WeakHashMap<String,String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("a","a");
    }
}
