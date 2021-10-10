package com.wsy.java.juc.learn.linkedlist;

/**
 * 双端链表，包含头尾节点
 */
public class DoublePointLinkedList {

    private class Node{
        private Node next;
        private Object value;

        public Node (Object value) {
            this.value = value;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    //头插法
    public Object addHead(Object o){
        Node node = new Node(o);
        if(size == 0 ){
            head = node;
            tail = node;
            size++;
        }else {
            node.next = head;
            head = node;
            size++;
        }
        return o;
    }
    public Object deleteHead(){
        if(size == 0 ){
            return null;
        }
        if(size == 1){
            Object value = head.value;
            head = null;
            tail = null;
            size --;
            return value;
        }
        Object value = head.value;
        head = head.next;
        size --;
        return value;
    }
    //尾插法
    public Object addTail(Object o ){
        Node node = new Node(o);
        if (size == 0 ){
             head = node;
             tail = node;
             size++;
         }else {
            tail.next = node;
            tail = node;
            size++;
        }
        return o;
    }
    //按照索引插入从0开始
    public Object addIndex(Object o,int index){
       if(index < 0 || index >= size){
           return null;
       }
       Node node = new Node(o);
       if(size == 0){
           head = node;
           tail = node;
           size++;
           return o;
       }
       if (index == 0){
           node.next = head;
           head = node;
           size ++;
           return o;
       }
       Node current = head;
       int temp = index;
       while ((temp-1) > 0 ){
           current = current.next;
           temp--;
       }
       Node next = current.next;
       current.next = node;
       node.next = next;
       size++;
       if(index == (size-1)){
           tail = node;
       }
       return o;
    }
    //删除指定元素
    public boolean deleteObject(Object o){
        if(size == 0 ){
            return false;
        }
        Node previous = null;
        Node node = head;
        while (node.value != o){
            if (node == tail){
                return  false;
            }
            previous = node;
            node = node.next;
        }
        previous.next = node.next;
        if(node == head){
            head = node.next;
        }
        if(node == tail){
            tail = previous;
        }
        node = null;
        size--;
        return  true;
    }
    public boolean deleteIndex(int index){
        if (size == 0 || index < 0 || index > size){
            return false;
        }

        Node previous = null;
        Node node = head;
        int temp = index;
        while (temp > 0){
            previous = node;
            node = node.next;
            temp --;
        }
        previous.next = node.next;
        if(index == 0){
            head = head.next;
        }
        if(index == (size-1)){
            tail = previous;
        }
        size--;
        node=null;
        return true;
    }

    public Object getTail(){
        return tail.value;
    }
    public Object getHead(){
        return head.value;
    }
    public boolean deleteTail(){
        return deleteIndex(size-1);
    }

    public Object findObject(Object o){
        if (size == 0){
            return  null;
        }
        Node node = head;

        while (node.value != o){
            if(node == tail){
                return false;
            }
            node = node.next;
        }
        return  o;
    }

    public Object findIndex(int index){
        if(size == 0 || index < 0 || index > (size-1)){
            return null;
        }
        Node node = head;
        while (index > 0){
            node = node.next;
            index--;
        }
        return node.value;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void printList(){
       if(size == 0){
           System.out.println("[]");
           return;
       }
        System.out.print("[");
        Node node = head;
        while (node != null){
            if(node == tail){
                System.out.print(node.value);
            }else {
                System.out.print(node.value + "->");
            }
            node = node.next;
        }
        System.out.println("]");
    }

    public int getSize () {
        return size;
    }
}
