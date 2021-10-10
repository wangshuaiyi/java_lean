package com.wsy.java.juc.learn.linkedlist;

import java.util.LinkedList;

/**
 * 单向链表
 */
public class SingleLinkedList {
    private int size = 0;//记录链表的长度
    private Node head = null;//链表头部

    private class Node{
        private Object value;
        private Node next;
        public Node(Object value,Node next){
            this.value = value;
            this.next = next;
        }

        public Node (Object value) {
            this.value = value;
        }

    }
    //头插法
    public Object addHead(Object o){
        //TODO 考虑一下线程安全
        Node node = new Node(o);
        if(size == 0 ){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        size++;
        return o;
    }
    //删除头部
    public Object deleteHead(){
        if(size == 0){
            return null;
        }
        Object o = head.value;
        head = head.next;
        return o;
    }
    //尾插法
    public Object addTail(Object o ){
        Node node = new Node(o);
        if(size == 0){
            head = node;
        }else {
            Node t = head;
            Node tail = t;
            while (t != null){
                tail = t;
                t = t.next;
            }
            tail.next  = node;
        }
        return o;
    }
    //按照索引插入从0开始
    public Object addIndex(Object o,int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }else if(index == 0){
            Node node = new Node(o);
            node.next = head;
            head = node;
        }else {
            Node node = new Node(o);
            Node t = head;
            for(int i = 0; i < index-1 ; i++ ){
                t = t.next;
            }
            Node next = t.next;
            t .next = node;
            node.next = next;

        }
        return o;
    }

    //删除指定元素
    public boolean deleteObject(Object o){
        if(size == 0 ){
            return false;
        }
        Node previous = null;
        Node current = head;

        while (current.value != o){
            if(current.next == null){
                return false;
            }
            previous = current;
            current = current.next;
        }
        if(previous == null){
            head = head.next;
            size --;
        }else {
           previous.next =  current.next ;
           current = null;
           size --;
        }
        return true;
    }

    //删除指定index
    public boolean deleteIndex(int index){
        if(index < 0 || index > size || size == 0){
            return false;
        }
        if(index == 0){
            head = head.next;
            size --;
        }else {
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++){
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            current = null;
            size --;
        }
        return true;
    }

    public Object findObject(Object o){
        if(size == 0){
            return null;
        }
        Node current = head;
        while (current.value != o){
            if (current.next == null){
                return null;
            }else {
                current = current.next;
            }
        }
        return o;
    }
    public Object findIndex(int index){
        if(index < 0 || index > size || size ==0){
            return null;
        }
        Node node = head;
        for (int i = 0 ; i < index; i++){
            node = node.next;
        }
        return  node.value;
    }

   public boolean isEmpty(){
        return size == 0;
   }
   public void printList(){

        if (size == 0 ){
            System.out.println("[]");
            return;
        }

        Node node = head;
       System.out.print("[");
        while (node != null){
            if(node.next == null){
                System.out.print(node.value);
            }else {
                System.out.print(node.value +" ->");
            }
            node = node.next;
        }
       System.out.println("]");

   }

    public int getSize () {
        return size;
    }
}
