package other.reference;

/**
 * Reference （参考Reference 抽象类及子类)
 * 强引用 ：如new 对象。不会被GC 回收。
 * SoftReference:对于软引用关联的对象，只有内存不足的时候JVM才会回收该对象，防止OOM。适合：页面，图片等缓存。
 * WeakReference: 当JVM进行下一次垃圾回收时，无论内存是否充足，都会回收弱引用关联的对象。
 * Weak references are most
 * often used to implement canonicalizing mappings.如：WeakHashMap
 * PhantomReference:在任何时候都可被回收。无法通过引用来获取一个对象实例。get（）方法返回null。唯一目的：当这个对象
 * 被垃圾收集器回收时收到一条系统通知。
 * 垃圾收集器 通过可达性分析算法来确定对象不可达。然后筛选此对象是否有必要执行finalize()方法。
 * 执行finalize（）方法的两个条件
 * 1、重写finalize（）方法。
 * 2、finalize()之前没被调用过，因为对象的finalize()方法只能被执行一次。t
 * 通过重写finalize()方法”自我拯救“
 */
public class Test {
    public static  Test Hook = null;
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println( "执行finalize方法");
        Test.Hook=this;
    }
    public static void main(String [] args)throws InterruptedException {
        Hook  = new Test();
        // 第一次拯救
        Hook = null;
        System.gc();
        Thread.sleep( 500 );
        // 等待finalize执行
        if(Hook != null ) {
            System.out.println(  "我还活着" );
        } else {
            System .out.println( "我已经死了" );
        }

        // 第二次，代码完全一样
        Hook = null;
        System.gc();
        Thread.sleep( 500 );
        // 等待finalize执行
        if(Hook != null ) {
            System.out.println(  "我还活着" );
        } else {
            System .out.println( "我已经死了" );
        }
    }
}
