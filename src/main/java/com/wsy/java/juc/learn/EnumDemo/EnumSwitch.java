package com.wsy.java.juc.learn.EnumDemo;

public class EnumSwitch {
    Signal color = Signal.BLACK;
    public void change(){
       switch (color){
           case RED:
               color = Signal.YELLOW;
               break;
           case BLACK:
               color = Signal.RED;
               break;
           default:
       }
   }
}

enum Signal{
    GREEN,RED,BLACK,YELLOW
}
