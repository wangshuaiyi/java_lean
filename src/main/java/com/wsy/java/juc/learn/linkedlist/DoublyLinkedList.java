package com.wsy.java.juc.learn.linkedlist;

public class DoublyLinkedList {
    private class Node{
        Node pervious;
        Node next;
        Object value;

        public Node (Object value) {
            this.value = value;
            this.pervious = null;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public void addHead(Object o){
        Node node = new Node(o);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            head.pervious = node;
            node.next = head;
            head = node;
            size ++;
        }
    }
    public void addIndex(Object o,int index){
        Node newNode = new Node(o);
        if(index < 0 || index > (size-1)){
            return;
        }
        if(size == 0){
            head = newNode;
            tail = newNode;
            size ++;
            return;
        }
        Node previousNode = null;
        Node node = head;
        for(int i = 0; i < index ; i++){
            previousNode = node;
            node = node.next;
        }

       if(previousNode == null){
            newNode.next = head;
            head.pervious = newNode;
            head = newNode;
            size++;
            return;
       }else{
               previousNode.next.pervious = newNode;
               newNode.next = previousNode.next;
               previousNode.next = newNode;
               newNode.pervious = previousNode;
               size++;
       }
    }
    public void addTail(Object o){
        Node node = new Node(o);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            node.pervious = tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }
    public Object getTail(){
        return tail.value;
    }
    public Object getHead(){
        return head.value;
    }
    public boolean deleteHead(){
        if(size == 0 ){
            return false;
        }
        if(size == 1){
            tail = null;
            head = null;
        }else {
            head = head.next;
            head.pervious = null;
        }
        size --;
        return true;
    }
    public boolean deleteTail(){
        if(size == 0){
            return false;
        }
        if(size == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.pervious;
            tail.next = null;
        }
        size -- ;
        return true;
    }

    public int getSize () {
        return size;
    }
    public boolean deleteIndex(int index){
        if(index < 0 || index > (size-1)){
            return false;
        }
        if(index == 0){
            return deleteHead();
        }else if(index == (size-1)){
            return deleteTail();
        }else {
            Node node = head;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
            node.pervious.next = node.next;
            node.next.pervious = node.pervious;
            size--;
            return true;
        }
    }

    public void printListHead(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        Node node = head;
        System.out.print("[");
        while (node != null){
            if (node.next == null){
                System.out.print(node.value);
            }else {
                System.out.print(node.value + "->");
            }
            node = node.next;
        }
        System.out.println("]");
    }
    public void printListTail(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node node = tail;
        while (node != null){
            if(node.pervious == null){
                System.out.print(node.value);
            }else {
                System.out.print( node.value + "->");
            }
            node = node.pervious;
        }
        System.out.println("]");
    }
}
