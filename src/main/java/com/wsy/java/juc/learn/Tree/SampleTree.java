package com.wsy.java.juc.learn.Tree;

import java.sql.SQLOutput;

/**
 * 树的种类有很多：
 * 二叉树
 * 二叉查找树
 * 平衡二叉树
 * 平衡二叉树查找树之AVL树
 * 平衡二叉树之红黑树
 * B树
 * B+树
 * 二叉树定义： 二叉树的每个节点至多只有两颗子树。
 * 满二叉树
 * 完全二叉树：最后一层可以不满，但是节点都连续集中在最左边（堆）
 *
 * 二叉查找树：
 * 若左子树不空，则左子树上所有的节点均小于根节点的值
 * 若右子树不空，则右子树上所有节点均大于根节点的值
 * 没有相等的值
 * */
public class SampleTree {

    public class Node{
        int value;
        Node left;
        Node right;

        public Node (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root = null;
    int size = 0;

    public int getSize () {
        return size;
    }

    /**
     * while
     * @param value
     */
    public void insert(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            size++;
            return;
        }
        Node parent = null;
        Node current = root;
        while(current != null){
            parent = current;
            if(value == current.value){
                return;
            }
            if (value > current.value){
                current = current.right;
                if(current == null){
                    parent.right = node;
                }
            }else {
                current = current.left;
                if(current == null){
                    parent.left = node;
                }
            }
        }

       size ++;
    }
   public void insertEnhance(int value){
        Node node = new Node(value);
        if(size == 0){
            root = node;
            size++;
            return;
        }
        recursion(root,node);
   }

   public void recursion(Node root,Node node){
        if (node.value > root.value){
            if(root.right == null){
                root.right = node;
                size++;
                return;
            }else{
                recursion(root.right,node);
            }
        }
       if (node.value < root.value){
           if(root.left == null){
               root.left = node;
               size++;
               return;
           }else{
               recursion(root.left,node);
           }
       }
       if (node.value == root.value){
            return;
       }
   }
    //前序遍历
   public void preOrder(Node node){
        if(node != null){
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
   }
    //中序遍历
    public void infixOrder(Node node){
        if(node != null){
            infixOrder(node.left);
            System.out.print(node.value + " ");
            infixOrder(node.right);
        }
    }
    //后序遍历
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
   public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.value != key){
            parent = current;
            if(key > current.value){
                isLeftChild = false;
                current = current.right;
            }else {
                isLeftChild = true;
                current = current.left;
            }
            if(current == null){
                return false;
            }
        }

        //如果当前需要删除的节点没有子节点，直接删除
       if(current.left == null && current.right == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.left = null;
            }else {
                parent.right = null;
            }
            return true;
        //当前节点有一个子节点，且是左节点
        }else if(current.left != null && current.right == null){
            if(current == root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.right;
            }else {
                parent.left = current.right;
            }
            return true;
           //当前节点有一个子节点，且是右节点
       }else if(current.left == null && current.right != null){
            if(current == root){
                root = current.right;
            }else if(isLeftChild){
                parent.right = current.left;
            }else {
                parent.right = current.right;
            }
       }else {
            //当前节点存在两个子节点
           Node successor = getSuccessor(current);
           if(current == root){
               root = successor;
           }else if(isLeftChild){
               parent.left = successor;
           }else {
               parent.right = successor;
           }
           successor.left = current.left;
           return true;
       }
        return false;
   }

   public Node getSuccessor(Node delNode){
        Node parent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while (current != null){
            parent = successor;
            successor = current;
            current = current.left;
        }
        if(successor != delNode.right){
            parent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
   }







}
