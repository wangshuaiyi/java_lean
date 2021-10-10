package com.wsy.java.juc.learn.QueueDemo;

import com.wsy.java.juc.learn.Person;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.concurrent.*;

public class QueueDemo {
    public static void main (String[] args) throws InterruptedException {
        queueDemo3();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        LinkedTransferQueue<Person> linkedTransferQueue = new LinkedTransferQueue<>();
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        ArrayDeque<Person> arrayDeque = new ArrayDeque<>();

    }

    private static void queueDemo3 () throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3,true);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.offer("a");
        linkedBlockingQueue.offer("c");
        linkedBlockingQueue.offer("b");
        System.out.println(linkedBlockingQueue.poll());
        System.out.println(linkedBlockingQueue.poll());
        System.out.println(linkedBlockingQueue.poll());

        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(3, (Comparator<Person>) (o1, o2) -> o1.getAge() - o2.getAge());
        priorityBlockingQueue.offer(new Person("a2",3));
        priorityBlockingQueue.offer(new Person("a1",2));
        priorityBlockingQueue.offer(new Person("a",1));
        System.out.println(priorityBlockingQueue.poll().toString());
        System.out.println(priorityBlockingQueue.poll().toString());
        System.out.println(priorityBlockingQueue.poll().toString());
//
        DelayQueue<DelayPerson> delayQueue = new DelayQueue();
        delayQueue.add(new DelayPerson("a",1,100));
        delayQueue.add(new DelayPerson("a",2,100));
        delayQueue.add(new DelayPerson("a",3,100));
        Thread.sleep(1000);
        System.out.println(delayQueue.poll().toString());
        System.out.println(delayQueue.poll().toString());
        System.out.println(delayQueue.poll().toString());
    }


}
