package algorithm.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class FIFO <E extends Map.Entry>{

    private LinkedBlockingQueue<E> linkedBlockingQueue;
    private int capacity;
    public FIFO(int capacity){
        this.capacity = capacity;
        linkedBlockingQueue = new LinkedBlockingQueue(capacity);
    }
    public void add(E e) throws InterruptedException {
        if(linkedBlockingQueue.contains(e)){
            System.out.println("key " + e.getKey()+" has exist");
            return;
        }else {
            if(linkedBlockingQueue.size()== capacity){
                linkedBlockingQueue.take();
            }
            linkedBlockingQueue.put(e);
        }
    }
    public E get(Object k){
        Iterator<E> iterator = linkedBlockingQueue.iterator();
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
    public String printFiFO(){
        return linkedBlockingQueue.toString();
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
            In<?, ?> in = (In<?, ?>) o;
            return Objects.equals(k, in.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k);
        }
    };

    public static void main(String[] args) throws InterruptedException {

        FIFO<In> fifo = new FIFO(5);
        for(int i=0;i<100;i++){
            In<Integer,Integer> in = new In(i,i*i);
            fifo.add(in);
        }
        fifo.add(new In(97,9999));
        System.out.println(fifo.printFiFO());
        System.out.println(fifo.get(98).getValue());
    }

}

