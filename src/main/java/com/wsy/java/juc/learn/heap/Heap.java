package com.wsy.java.juc.learn.heap;

/**
 * 堆：是由数组实现的
 * 1.是完全二叉树：若二叉树深度为h，则除第n层外，其他层的节点全部达到最大值，且第n层的所有节点都集中在左子树
  * 2.堆中某个节点总是不大于或者不小于其父节点的值
 * 根节点最大的堆叫最大堆
 * 根节点最小的堆叫最小堆
 *
 * 堆在存储器中的表示是数组，堆只是一个概念上的表示
 *
 * 堆的弱序：堆和二叉搜索树相比是弱序的。在二叉搜索树中，当前节点的值总是比左节点大比右节点小，因此按序遍历相对容易。而
 * 堆的组织规则是弱序。不能保证左右两个节点的大小，只能保证父节点比子节点大或者小。因此他不能在小于OlgN的时间内删除一个
 * 指定节点。不过对于快速移除最大节点，以及快速插入一个新节点的操作，堆比较占优势。
 * 8.用数组表示一棵树时，如果数组中节点的索引位x，则
 * 　　a.它的父节点的下标是：(x-1)/2；
 * 　　b.它的左子节点的下标为2*x + 1；
 * 　　c.它的右子节点的下标是2*x + 2；
 */
public class Heap {
    private HeapNode[] heapNodes;
    private int maxSize;
    private int currentSize;

    public Heap (int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapNodes = new HeapNode[maxSize];
    }
    public boolean isEmpty(){
        return (currentSize == 0);
    }
    public boolean insert(int value){
        if(currentSize == maxSize){
            return false;
        }
        HeapNode node = new HeapNode(value);
        heapNodes[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp (int index) {
        int parent = (index -1)/2;
        HeapNode bottom = heapNodes[index];
        while (index > 0 && heapNodes[parent].getIndex() < bottom.getIndex()){
            heapNodes[index] = heapNodes[parent];
            index = parent;
            parent = (index - 1)/2;
        }
        heapNodes[index] = bottom;
        //int parent
    }
    public HeapNode remove(){
        HeapNode root = heapNodes[0];
        heapNodes[0] = heapNodes[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown (int index) {
        int largeChild;
        HeapNode top = heapNodes[index];
        while (index < currentSize / 2){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if(rightChild < currentSize && heapNodes[leftChild].getIndex() < heapNodes[rightChild].getIndex()){
                largeChild = rightChild;
            }else {
                largeChild = leftChild;
            }
            if(top.getIndex() >= heapNodes[largeChild].getIndex()){
                break;
            }
            heapNodes[index] = heapNodes[largeChild];
            index = largeChild;
        }
        heapNodes[index] = top;
    }

    public boolean change(int index,int newvalue){
        if(index < 0 || index >= currentSize){
            return false;
        }
        int oldValue = heapNodes[index].getIndex();
        heapNodes[index].setIndex(newvalue);
        if(oldValue < newvalue){
            trickleUp(index);
        }else{
            trickleDown(index);
        }
        return true;
    }
    public void displayHeap(){
        System.out.print("heap:");
        for(int i = 0; i < currentSize; i++){
            if(heapNodes[i] != null){
                System.out.print(heapNodes[i].getIndex()+" ");
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
                System.out.print(heapNodes[j].getIndex());
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
