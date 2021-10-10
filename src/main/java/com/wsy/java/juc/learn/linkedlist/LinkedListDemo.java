package com.wsy.java.juc.learn.linkedlist;

/**
 * 链表：是一种线性表，但是并不会按照线性的顺序存储数据，而是每一个节点里存到下一个节点的指针
 * 主要分为单向链表、双向链表,双端链表（包含头尾节点的链表）
 */
public class LinkedListDemo {

    public static void main(String[] args){
     //   SingleLinkedListDemoFunction();
      //  doublePointLinkListDemo();
        //OrderLinkedListDemo();
        //DoublyLinkedList();

    }

    private static void DoublyLinkedList () {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        doublyLinkedList.addHead("5");
        doublyLinkedList.addHead("6");
        doublyLinkedList.addHead("7");
        doublyLinkedList.addHead("9");
        doublyLinkedList.addHead("11");
        doublyLinkedList.addHead("13");
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        doublyLinkedList.addTail("4");
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        System.out.println(doublyLinkedList.getHead());
        System.out.println(doublyLinkedList.getTail());
        doublyLinkedList.addIndex("15",0);
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        System.out.println(doublyLinkedList.getSize());
        doublyLinkedList.addIndex("1",7);
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        doublyLinkedList.deleteTail();
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        doublyLinkedList.deleteHead();
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
        doublyLinkedList.deleteIndex(8);
        doublyLinkedList.printListHead();
        doublyLinkedList.printListTail();
    }

    private static void OrderLinkedListDemo () {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.addNode(5);
        orderLinkedList.addNode(3);
        orderLinkedList.addNode(6);
        orderLinkedList.addNode(9);
        orderLinkedList.addNode(1);
        orderLinkedList.addNode(2);
        orderLinkedList.addNode(4);
        orderLinkedList.addNode(0);
        orderLinkedList.printList();
    }

    private static void doublePointLinkListDemo () {
        DoublePointLinkedList pointLinkedList = new DoublePointLinkedList();
        pointLinkedList.printList();
        pointLinkedList.addHead("5");
        pointLinkedList.addHead("6");
        pointLinkedList.addHead("7");
        pointLinkedList.addHead("8");
        pointLinkedList.addHead("9");
        pointLinkedList.addHead("10");
        pointLinkedList.printList();
        pointLinkedList.addTail("4");
        pointLinkedList.printList();
        System.out.println(pointLinkedList.getHead());
        System.out.println(pointLinkedList.getTail());
        pointLinkedList.addIndex("11",0);
        pointLinkedList.printList();
        System.out.println(pointLinkedList.getSize());
        pointLinkedList.addIndex("12",2);
        pointLinkedList.printList();
        pointLinkedList.addTail("13");
        pointLinkedList.printList();
        pointLinkedList.deleteTail();
        pointLinkedList.printList();
        System.out.println( pointLinkedList.getSize());
    }

    private static void SingleLinkedListDemoFunction () {
        SingleLinkedList list = new SingleLinkedList();
        list.addHead("5");
        list.addHead("6");
        list.addHead("8");
        list.addHead("9");
        list.addHead("10");
        list.addTail("4");
        list.printList();
        list.addIndex("7",0);
        list.printList();
        list.addIndex("11",3);
        list.printList();
        System.out.println( list.findIndex(0));
        System.out.println( list.findIndex(5));
        System.out.println( list.findIndex(10));
        System.out.println( list.findIndex(-1));
        System.out.println(list.findObject("6"));
        System.out.println(list.findObject("-1"));
        list.deleteObject("7");
        list.printList();
        list.addHead("7");
        list.printList();
        list.deleteObject("8");
        list.printList();
        list.deleteObject("4");
        list.printList();
        list.addTail("4");
        list.printList();
        list.deleteIndex(0);
        list.printList();
        list.addHead("7");
        list.printList();
        list.deleteIndex(2);
        list.printList();
        list.deleteIndex(5);
        list.printList();
    }

}
