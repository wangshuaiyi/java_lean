package com.wsy.java.juc.learn.IODemo;

import java.io.*;

public class ObjectStreamDemo {

    public static void main (String[] args) {
        String str = "124";
        try  {
            FileOutputStream f = new FileOutputStream("test.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(f);
            objectOutputStream.writeObject(str);
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.readObject();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
