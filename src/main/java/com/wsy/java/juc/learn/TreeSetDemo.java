package com.wsy.java.juc.learn;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet是有序不重复的集合。
 *    继承了AbstractSet并且实现了NavigableSet接口。底层是TreeMap的实现的。
 *    主要方法有Set的add, remove get等方法
 *    还有NavigableSet的两类方法： 一类是提供元素项的导航方法，返回某个元素；另外是集合的导航方法，返回某个集合
 *
 *    lower、floor、ceiling 和 higher分别返回小于、小于等于、大于等于、大于给定元素的元素，如果不存在就返回null.
 *
 */
public class TreeSetDemo {

    public static void main(String[] agrs){
       // demo_init();
        System.out.println(valEquals(null,null));
    }

    /**
     * 需要传入一个比较器，来确定谁打谁小。
     * put核心代码
     *          do {
     *                 parent = t;
     *                 cmp = cpr.compare(key, t.key);
     *                 if (cmp < 0)
     *                     t = t.left;
     *                 else if (cmp > 0)
     *                     t = t.right;
     *                 else
     *                     return t.setValue(value);
     *             } while (t != null);
     */
    public static void demo_init(){
        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge() != 0? o1.getAge() - o2.getAge():o1.getName().hashCode() - o2.getName().hashCode());
        treeSet.add(new Person("aa",11));
        treeSet.add(new Person("bb",9));
        treeSet.add(new Person("cc",35));
        treeSet.add(new Person("ff",8));
        treeSet.add(new Person("bb",11));
        treeSet.add(new Person("ee",44));

        System.out.println("==============遍历==============");
        treeSet.stream().forEach(p-> System.out.println(p));
        System.out.println("==========小于该元素的最大元素========");
        System.out.println(treeSet.lower(new Person("bb",11)));
        System.out.println("===========大于该元素的最小元素========");
        System.out.println(treeSet.higher(new Person("bb",11)));


    }
    public static boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }

}
