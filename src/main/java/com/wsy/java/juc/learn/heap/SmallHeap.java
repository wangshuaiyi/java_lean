package com.wsy.java.juc.learn.heap;

public class SmallHeap {
    private HeapNode[] nodes;
    private int currentSize ;
    private int maxSize;

    public SmallHeap (int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.nodes = new HeapNode[maxSize];
    }

    public boolean insert(int key){
        if(currentSize == maxSize){
            return false;
        }
        nodes[currentSize] = new HeapNode(key);
        tricklyUp(currentSize++);
        return true;
    }

    public void tricklyUp (int index) {
        int parent = (index - 1)/2;
        HeapNode bottom = nodes[index];
        while (index > 0 && nodes[parent].getIndex() > bottom.getIndex()){
            nodes[index] = nodes[parent];
            index = parent;
            parent = (index - 1)/2;
        }
        nodes[index]=bottom;
    }
    public HeapNode remove(int index){
        HeapNode root = nodes[index];
        nodes[index] = nodes[--currentSize];
        nodes[currentSize] = null;
        tirckluDown(index);
        return root;
    }

    public void tirckluDown (int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int small = 0;
        HeapNode top = nodes[index];
        while (index < currentSize / 2){
            if((nodes[left].getIndex() > top.getIndex())&(nodes[right].getIndex() > top.getIndex())){
                break;
            }
            if(nodes[left].getIndex() < top.getIndex()){
                small = left;
            }
            if(nodes[right].getIndex() < top.getIndex()){
                small = right;
            }
            nodes[index] = nodes[small];
            index = small;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
        nodes[index] = top;
    }
    public boolean change(int index , int key){
        if(index < 0 || index > (currentSize-1)){
            return false;
        }
        int oldValue = nodes[index].getIndex();
        nodes[index].setIndex(key);
        if(key >  oldValue){
            tirckluDown(index);
        }
        if(key <  oldValue) {
            tirckluDown(index);
        }
        return true;
    }
    public void displayHeap(){
        System.out.print("heap:");
        for(int i = 0; i < currentSize; i++){
            if(nodes[i] != null){
                System.out.print(nodes[i].getIndex()+" ");
            }else {
                System.out.print("--");
            }
        }
        System.out.println("");
        int nBlanks = 32;
        int itemsPerrow = 1;
        int column = 0;
        int j = 0;
        String dots = "........................";
        System.out.println(dots+dots);
        while (currentSize > 0){
            if(column == 0){
                for (int i = 0; i < nBlanks; i ++){
                    System.out.print(" ");
                }
            }
            System.out.print(nodes[j].getIndex());
            if(++j == currentSize){
                break;
            }
            if(++ column == itemsPerrow){
                nBlanks /= 2;
                itemsPerrow *= 2;
                column = 0;
                System.out.println("");
            }else {
                for(int i = 0; i < nBlanks * 2 - 2; i++){
                    System.out.print(" ");
                }
            }


        }
        System.out.println("\n"+dots+dots);
    }


}
