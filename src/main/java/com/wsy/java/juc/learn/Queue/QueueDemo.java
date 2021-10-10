package com.wsy.java.juc.learn.Queue;

/**
 * 队列：
 * 队列一种特殊的线性表，特殊之处在于它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 *现金显出。
 *  1.单向队列
 *  2.双向队列
 *  3.优先级队列
 */
public class QueueDemo {
    public static void main (String[] args) {
        SinglePointQueue queue = new SinglePointQueue(10);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        queue.printQueue();
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());


    }
}
