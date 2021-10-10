package com.wsy.java.juc.learn.heap;

public class HeapDemo {

    public static void main (String[] args) {
       SmallHeap heap = new SmallHeap(20);
       heap.insert(50);
       heap.insert(30);
       heap.insert(10);
       heap.insert(20);
       heap.insert(60);
       heap.insert(70);
       heap.insert(40);
       heap.insert(45);
       heap.insert(55);
       heap.insert(5);
       heap.insert(100);
       heap.insert(80);
       heap.insert(90);
       heap.displayHeap();

//       heap.remove(3);
//       heap.displayHeap();
//       heap.insert(45);
//       heap.displayHeap();
       heap.change(2,200);
       heap.displayHeap();
    }
}
