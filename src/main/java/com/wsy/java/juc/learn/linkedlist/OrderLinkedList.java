package com.wsy.java.juc.learn.linkedlist;

/**
 * 有序链表。在这个链表中 按照关键之有序排列。有序链表由于有序数组的地方是插入的速度。（因为元素是不需要移动的）。
 * 另外链表可以扩展到全部有效的使用内存。而数组只能局限于一个固定的大小中
 */
public class OrderLinkedList {

    private class Node{
        int value;
        Node next;

        public Node (int value) {
            this.value = value;
        }
    }
    private Node head = null;
    private int size = 0;

    public int addNode(int i){
        Node node = new Node(i);
        if (size == 0 ){
            head = node;
            size++;
        }else{

            Node current = head;
            Node previois = null;
            while (current.value > i ){
                if(current.next == null){
                    current.next = node;
                    size++;
                    return i;
                }else{
                    previois = current;
                    current = current.next;
                }
            }
            if (previois == null){
                node.next = head;
                head = node;
            }else {
                previois.next = node;
                node.next = current;
            }
            size++;
        }
        return i;
    }

  public void printList(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node current = head;
        while (current != null){
            if(current.next == null){
                System.out.print(current.value);
            }else{
                System.out.print(current.value + " -> ");
            }
            current = current.next;
        }
      System.out.println("]");
  }



}
