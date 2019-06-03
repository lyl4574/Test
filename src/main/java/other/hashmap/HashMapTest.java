package other.hashmap;
/*
HashMap是非线程安全的,HashMap的线程不安全主要体现在多线程resize时的死循环及使用迭代器时的fast-fail上。(????)
散列表的载荷因子定义为： a = 填入表中的元素个数 / 散列表的长度
HashMap要实现的是哈希表的效果，尽量实现O(1)级别的增删改查。具体实现则是同时使用了数组和链表，可以认为最外层是一个数组，数组的每个元素是一个链表的表头。

Key的哈希值的分布直接决定了所有数据在哈希表上的分布或者说决定了哈希冲突的可能性，
因此为防止糟糕的Key的hashCode实现（例如低位都相同，只有高位不相同，与2^N-1取与后的结果都相同）,
使用下列方法 尽量均匀分布从,而尽可能减少哈希冲突。
  static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

在计算机中，取模的代价远高于位操作的代价，因此HashMap要求数组的长度必须为2的N次方。此时将Key的哈希值对2^N-1进行与运算，其效果即与取模等效。
   index = hash & (length-1)

HashMap并不要求用户在指定HashMap容量时必须传入一个2的N次方的整数，而是会通过Integer.highestOneBit算出比指定整数大的最小的2^N值
static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }

HashMap允许Key和Value为null，而ConcurrentHashMap不允许

 */
public class HashMapTest {

}
