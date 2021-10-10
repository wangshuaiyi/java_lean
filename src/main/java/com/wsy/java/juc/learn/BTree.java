package com.wsy.java.juc.learn;

/**
 * 红黑树是一种自平衡的二叉查找书，（AVL)平衡二叉树的一种。它可以在O（logN）的时间做查找
 * https://www.jianshu.com/p/e136ec79235c
 * 左旋只影响旋转结点和其右子树的结构，把右子树的结点往左子树挪了。
 * 右旋只影响旋转结点和其左子树的结构，把左子树的结点往右子树挪了。
 * 红黑树总是通过旋转和变色达到自平衡。
 */
public class BTree <K,V> {
    Entry<K,V> root = null;

    public V put(K key, V value){
        Entry<K,V> t = root;
        if(root == null){
            root = new Entry<>(key,value,null);
            return null;
        }
        Entry<K,V> parent;
        do {
            parent = t;
            if(compare(t.getValue(),value) > 0 ){
                 t = t.right;
            }else  if (compare(t.getValue(),value) < 0 ){
                t = t.left;
            }else {
                return t.setValue(value);
            }
        }while (t != null);

        Entry<K,V> e = new Entry<>(key,value,parent);

        if(compare(t.getValue(),value) > 0 ){
            parent.right = e;
        }else {
            parent.left = e;
        }

        return null;
    }
    public int compare(Object o1, Object o2){
        return o1.hashCode() - o2.hashCode();
    }


}
