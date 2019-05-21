package synchronizedTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁，也就是递归锁。重入性是基于Thread.currentThread()实现的。作用：防止在同一线程中多次获取锁而导致死锁发生。
 * synchronized 也是可重入锁。
 * 实现：为每个锁关联一个获取计数器和一个所有者线程，当计数值为0时，这个锁就被认为是没有被任何线程所占有的。
 * 当线程请求一个未被持有的锁时，计数值将会递增。而当线程退出同步代码时，计数器会相应地递减。当计数值为0时，则释放该锁。
 *
 * 自旋锁：自旋锁不会引起调用者睡眠，所以自旋锁的效率远 高于互斥锁。
 *  缺点：
 *  1、自旋锁一直占用CPU，他在未获得锁的情况下，一直运行－－自旋，所以占用着CPU，如果不能在很短的时 间内获得锁，这无疑会使CPU效率降低。
 *  2、在用自旋锁时有可能造成死锁，当递归调用时有可能造成死锁，调用有些其他函数也可能造成死锁
 *
 *  两种锁的区别
 * 互斥锁的起始原始开销要高于自旋锁，但是基本是一劳永逸，临界区持锁时间的大小并不会对互斥锁的开销造成影响，而自旋锁是死循环检测，加锁全程消耗cpu，起始开销虽然低于互斥锁，但是随着持锁时间，加锁的开销是线性增长。
 * 两种锁的应用
 * 互斥锁用于临界区持锁时间比较长的操作，比如下面这些情况都可以考虑
 * 1 临界区有IO操作
 * 2 临界区代码复杂或者循环量大
 * 3 临界区竞争非常激烈
 * 4 单核处理器
 *
 * 至于自旋锁就主要用在临界区持锁时间非常短且CPU资源不紧张的情况下，自旋锁一般用于多核的服务器。
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        //默认是非公平锁， 参数 true时，公平锁 按队列顺序 获取锁。
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" begin ");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();
        new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" begin ");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();
    }
}
