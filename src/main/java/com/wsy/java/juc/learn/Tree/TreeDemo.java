package com.wsy.java.juc.learn.Tree;

public class TreeDemo {
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

    public void insert(int value){
        Node node = new Node(value);


    }
    public boolean insertAction1(Node parent,Node node){
        if(parent == null){
            parent = node;
            size++;
            return true;
        }
        if (parent.data > node.data){
           return insertAction1(parent.left,node);
        }
        if(parent.data < node.data){
            return insertAction1(parent.right,node);
        }
        return false;
    }
    public boolean insertAction2(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            return true;
        }
        Node current = root;
        while(current != null){
            if(current.data == node.data){
                return false;
            }else if(current.data < node.data){
                if(current.right == null){
                    current.right = node;
                    size++;
                    return true;
                }
                current = current.right;
            }else {
                if(current.left == null){
                    current.left = node;
                    size++;
                    return true;
                }
                current = current.left;
            }
        }
        return false;
    }


    public Node find(int value){
        if(root == null){
            return null;
        }
        Node current = root;
        while (current != null){
            if(current.data == value){
                return current;
            }else if(current.data > value){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean delete(int value){
         if(root == null){
             return false;
         }
         Node parent = root;
         Node current = root;
         boolean isLeftChild = false;
        while (current.data != value){
            parent = current;
            if(current.data > value){
                current = current.left;
                isLeftChild = true;
            }else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current.left == null && current.right == null){
            if(current == root){
                root = null;
                return true;
            }
        }else if(current.left == null && current.right != null){
            if (current == root){
                root = current.right;
            }else {
                if(isLeftChild){
                    parent.left = current.right;
                }else {
                    parent.right = current.right;
                }
            }

            return true;
        }else if(current.left != null && current.right == null){
            if(current == root){
                root = current.left;
            }else {
                if(isLeftChild){
                    parent.left = current.left;
                }else {
                    parent.right = current.left;
                }
            }
            return true;
        }else {
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else  {
                if(isLeftChild){
                    parent.left = successor;
                }else {
                    parent.right = successor;
                }
            }
            //TODO
            parent.left = current.left;
            return true;
        }
        return false;
    }

    private Node getSuccessor (Node delNode) {
        Node parent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while (current != null){
            successor = current;
            current = current.left;
        }
        if(delNode.right != successor){
            parent.right = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }


}
