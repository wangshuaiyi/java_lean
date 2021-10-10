package com.wsy.java.juc.learn.SetDemo;



import com.wsy.java.juc.learn.Person;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetDemo {
    public static void main (String[] args) {
        HashSet<Person> hashSet = new HashSet();
        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge() != 0? o1.getAge() - o2.getAge():o1.getName().hashCode() - o2.getName().hashCode());
        LinkedHashSet<Person> linkedHashSet = new LinkedHashSet<>();
        CopyOnWriteArraySet<Person> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
    }
}
