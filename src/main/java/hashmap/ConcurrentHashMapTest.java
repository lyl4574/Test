package hashmap;

/*
ConcurrentHashMap线程安全，而HashMap非线程安全
HashMap允许Key和Value为null，而ConcurrentHashMap不允许
HashMap不允许通过Iterator遍历的同时通过HashMap修改，而ConcurrentHashMap允许该行为，并且该更新对后续的遍历可见

 */
public class ConcurrentHashMapTest {
}
