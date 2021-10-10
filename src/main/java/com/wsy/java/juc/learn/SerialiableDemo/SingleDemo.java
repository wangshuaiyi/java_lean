package com.wsy.java.juc.learn.SerialiableDemo;

import java.io.*;

public class SingleDemo {
    public static void main (String[] args) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(Singleton.getSingleton());
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance == Singleton.getSingleton());
    }
}

