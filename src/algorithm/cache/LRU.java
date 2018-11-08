package algorithm.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

/*
     LRU(Least Recently Used ),最近最少使用，总是淘汰最后访问时间最久的元素。
       这种算法存在着问题：可能由于一次冷数据的批量查询而误淘汰大量热点的数据。

       1.新数据插入到链表头部；
       2.每当缓存命中（即缓存数据被访问），则将数据移到链表头部；(与LRU 的区别，LRU不会将数据移到链表头部)
       3.当链表满的时候，将链表尾部的数据丢弃。
 */
public class LRU<E extends Map.Entry>{
    private LinkedBlockingDeque<E> linkedBlockingDeque;
    private int capacity;
    public LRU(int capacity){
        this.capacity = capacity;
        linkedBlockingDeque = new LinkedBlockingDeque(capacity);
    }
    public void add(E e) throws InterruptedException {
        if(linkedBlockingDeque.contains(e)){
            System.out.println("key " + e.getKey()+" has exist");
            linkedBlockingDeque.remove(e);
            linkedBlockingDeque.put(e);
        }else {
            if(linkedBlockingDeque.size()== capacity){
                linkedBlockingDeque.take();
            }
            linkedBlockingDeque.put(e);
        }
    }
    public E get(Object k){
        Iterator<E> iterator = linkedBlockingDeque.iterator();
        E v = null;
        while(iterator.hasNext()){
            E e = iterator.next();
            if(e.getKey() == k){
                v = e;
                break;
            }
        }
        return v;
    }
    public String printLRU(){
        return linkedBlockingDeque.toString();
    }

    static class In<K,V> implements Map.Entry<K,V>{
        private K k;
        private V v;
        public In(K k,V v){
            this.k = k;
            this.v = v;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V v) {
            this.v = v;
            return v;
        }
        @Override
        public String toString(){
            return this.k.toString()+"-"+this.v.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LRU.In<?, ?> in = (LRU.In<?, ?>) o;
            return Objects.equals(k, in.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k);
        }
    };

    public static void main(String[] args) throws InterruptedException {

        LRU<LRU.In> lru = new LRU(5);
        for(int i=0;i<100;i++){
            LRU.In<Integer,Integer> in = new LRU.In(i,i*i);
            lru.add(in);
        }
        lru.add(new LRU.In(97,9999));
        System.out.println(lru.printLRU());
        System.out.println(lru.get(97).getValue());
    }
}
