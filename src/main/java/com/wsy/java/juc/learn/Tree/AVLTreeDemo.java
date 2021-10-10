package com.wsy.java.juc.learn.Tree;

import com.wsy.java.juc.learn.heap.Heap;

import java.lang.management.MemoryManagerMXBean;
import java.util.Map;

/**
 * AVL Tree插入的时候有4中情况：
 * 1.在节点X的左节点的左子树插入元素
 * 2.在节点X的左节点的右子树插入元素
 * 3.在节点X的右节点的左子树插入元素
 * 4.在节点X的右节点的右子树插入元素
 *
 * 1 4是类似的
 * 2 3是类似的
 */
public class AVLTreeDemo {

    public class Node{
        public int data;
        public int hight;
        public Node left;
        public Node right;
        public Node (int data) {
            this.data = data;
            this.hight = 0;
        }

    }
    public Node root;
    public int size;

    public int getSize () {
        return size;
    }
    //前序遍历
    public void prePrint(Node node){
        if(node != null){
            System.out.print(node.data+" ");
            prePrint(node.left);
            prePrint(node.right);
        }
    }
    //中序遍历
    public void midPrint(Node node){
        if(node != null){
            prePrint(node.left);
            System.out.print(node.data+" ");
            prePrint(node.right);
        }
    }
    //后序遍历
    public void folPrint(Node node){
        if(node != null){
            prePrint(node.left);
            prePrint(node.right);
            System.out.print(node.data+" ");
        }
    }
    //左左单旋 场景1  左子树左节点 从左往右旋转  左子树成为父节点
    public Node singleLL(Node node){
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        node.hight = Math.max(height(node.left),height(node.right))+1;
        left.hight = Math.max(height(left.left),height(left.right))+1;
        return left;
    }
    //右右单旋
    public Node singleRR(Node node){
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        node.hight = Math.max(height(node.left),height(node.right))+1;
        right.hight = Math.max(height(right.left),height(right.right))+1;
        return  right;
    }
    //左右旋 左子树的右节点  先左节点右旋 然后该节点左旋
    public Node doubleLR(Node node){
        node.left = singleRR(node.left);
        return singleLL(node);
    }
  //右左旋 右子树的左节点 先右子树 左旋 然后该节点右旋
    public Node doubleRL(Node node){
        node.right = singleLL(node.right);
        return singleRR(node);
    }
    public Node insert(int data, Node parent){
        if (parent == null){
            parent = new Node(data);
        }else if(data < parent.data){
            parent.left = insert(data,parent.left);
            //插入后计算子树高度，等于2则需要重新恢复平衡，由于是左边插入，左子树的高度肯定大于等于右子树高度
            if((height(parent.left) - height(parent.right) == 2)){
                if (data < parent.left.data){
                    parent = singleLL(parent);
                }else {
                    parent = doubleLR(parent);
                }
            }
        }else if(data > parent.data){
            parent.right = insert(data,parent.right);
            if((height(parent.right) - height(parent.left)) == 2){
                if(data > parent.right.data){
                    parent = singleRR(parent);
                }else {
                    parent = doubleRL(parent);
                }
            }
        }
        //重新计算各个点的高度；
        parent.hight = Math.max(height(parent.left),height(parent.right)) + 1;
        return parent;
    }

    private int height (Node node) {
        if(node == null){
            return -1;
        }
        if (node.left == null && node.right == null){
            node.hight = 0;
        }else if(node.left ==null && node.right != null){
            node.hight =  height(node.right)+1;
        }else if(node.left != null && node.right == null){
            node.hight = height(node.left)+1;
        }else {
            node.hight = Math.max(height(node.left),height(node.right))+1;
        }
        return node.hight;
    }

    public Node remove(int data,Node parent){
        if(parent == null){
            return null;
        }

        if(data < parent.data){
            parent.left = remove(data,parent.left);

            if((height(parent.right) - height(parent.left)) == 2){
                Node current = parent.right;
                if(height(current.left) > height(current.right)){
                    parent = singleLL(parent);
                }else {
                    parent = doubleLR(parent);
                }
            }
        }else if(data > parent.data){
            parent.right = remove(data,parent.right);

            if((height(parent.left) - height(parent.right)) == 2){
                Node current = parent.right;
                if(height(current.right) > height(current.left)){
                    parent = singleRR(parent);
                }else {
                    parent = doubleRL(parent);
                }
            }
        }else if(parent.right != null && parent.left != null){
            parent.data = findMin(parent.right).data;
            parent.right = remove(parent.data,parent.right);
        }else {
            parent = (parent.left != null)? parent.left : parent.left;
        }

        if(parent != null){
            parent.hight = Math.max(height(parent.left),height(parent.right))+1;
        }
        return parent;
    }

    private Node findMin (Node node) {
        Node current = node;
        Node parent = node;
        while (current != null){
            parent = current;
            current = current.left;
        }
        return parent;
    }


}
