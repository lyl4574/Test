package hashmap;

/**
 * ConcurrentHashMap线程安全，而HashMap非线程安全
 * HashMap允许Key和Value为null，而ConcurrentHashMap不允许
 * HashMap不允许通过Iterator遍历的同时通过HashMap修改，而ConcurrentHashMap允许该行为，并且该更新对后续的遍历可见
 *
 *  ConcurrentHashMap 增加了Segment 层，每个Segment 原理上等同于一个 Hashtable， ConcurrentHashMap 为 Segment 的数组。
 *  向 ConcurrentHashMap 中插入数据或者读取数据，首先都要讲相应的 Key 映射到对应的 Segment，因此不用锁定整个类，
 *  只要对单个的 Segment 操作进行上锁操作就可以了。理论上如果有 n 个 Segment，那么最多可以同时支持 n 个线程的并发访问，
 *  从而大大提高了并发访问的效率。另外 rehash() 操作也是对单个的 Segment 进行的，所以由 Map 中的数据量增加导致的 rehash 的成本也是比较低的。
 */
public class ConcurrentHashMapTest {
}
