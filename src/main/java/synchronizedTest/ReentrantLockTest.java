package synchronizedTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁，也就是递归锁。作用：防止在同一线程中多次获取锁而导致死锁发生。
 * synchronized 也是可重入锁。
 * 实现：为每个锁关联一个获取计数器和一个所有者线程，当计数值为0时，这个锁就被认为是没有被任何线程所占有的。
 * 当线程请求一个未被持有的锁时，计数值将会递增。而当线程退出同步代码时，计数器会相应地递减。当计数值为0时，则释放该锁。
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
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
