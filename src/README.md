##TreeSet详解
底层是一个treemap与hashset一样。put的核心代码就是构建树的过程。
************************************
    public V put(K key, V value) {
           //获取根节点
            Entry<K,V> t = root;
            //根节点为null相当于当前set没有元素
            if (t == null) {
                compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;  
            //出现modCount 就要注意，此方法为线程不安全，相同的逻辑参见： ArrayList的add方法，hashMap的put方法
            //这个变量常被用来判断该数据结构是否变过，例如一下代码。
            //if (expectedModCount != modCount) {
            // throw new ConcurrentModificationException();
           // }
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {//如果构造器为null则使用默认构造器
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K,V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);//红黑树平衡的问题
        size++;
        modCount++;
        return null;
    }
 
 知识点：
 红黑树：
 
 
