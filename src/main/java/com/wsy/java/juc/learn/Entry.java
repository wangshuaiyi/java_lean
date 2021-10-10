package com.wsy.java.juc.learn;

import java.util.Map;

public class Entry<K,V>  {
    private final static boolean BLOCK = true;
    private final static boolean RED = false;
    K key;
    V value;
    Entry<K,V> parent;
    Entry<K,V> left;
    Entry<K,V> right;
    boolean color = BLOCK;
    Entry(K key,V value, Entry<K,V> parent){
        this.parent = parent;
        this.value = value;
        this.key = key;
    }


    public K getKey () {
        return key;
    }


    public V getValue () {
        return value;
    }


    public V setValue (V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    @Override
    public String toString () {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
