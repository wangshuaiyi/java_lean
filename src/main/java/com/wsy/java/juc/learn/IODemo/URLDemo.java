package com.wsy.java.juc.learn.IODemo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

    public static void main (String[] args) {
        try {
            URL image = new URL("");
            InputStream inputStream = image.openStream();

        } catch (Exception e) {
            e.printStackTrace();
        }

        InputStreamReader reader = new InputStreamReader(System.in);

    }
}
