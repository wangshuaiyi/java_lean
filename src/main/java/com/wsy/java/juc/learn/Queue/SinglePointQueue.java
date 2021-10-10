package com.wsy.java.juc.learn.Queue;

public class SinglePointQueue {
    private int[] que;
    private int maxSize;
    private int head;
    private int tail;
    private int currentSize;

    public SinglePointQueue (int maxSize) {
        this.maxSize = maxSize;
        this.que = new int[maxSize];
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
    }

    public int getSize () {
        return currentSize;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize;
    }

    public boolean insert(int key){
        if(isFull()){
            return false;
        }
        if(tail == maxSize-1){
            tail = -1;
        }
        que[++tail] = key;
        currentSize++;
        return true;
    }

    /**
     * 注意循环的问题，不管是尾指针到尾部还是头指针到尾部 需要该变它的值
     * @return
     */
    public int get(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }

        int key = que[head];
        que[head] = 0;
        head++;
        if(head == maxSize ){
            head = 0;
        }
        currentSize --;
        return key;
    }
    public int getHead(){
        return que[head];
    }
    public int getTailValue(){
        return que[tail];
    }

    public void printQueue(){
        System.out.print("[");
        for(int i = head; i <= tail; i ++){
            System.out.print(que[i]+ " ");
        }
        System.out.println("]");
    }
}
