package other.reference;

/**
 * Reference （参考Reference 抽象类及子类)
 * 强引用 ：如new 对象。不会被GC 回收。
 * SoftReference:对于软引用关联的对象，只有内存不足的时候JVM才会回收该对象，防止OOM。适合：页面，图片等缓存。
 * WeakReference: 当JVM进行垃圾回收时，无论内存是否充足，都会回收弱引用关联的对象。
 * Weak references are most
 * often used to implement canonicalizing mappings.如：WeakHashMap
 * PhantomReference:在任何时候都可被回收。
 */
public class Test {
}
