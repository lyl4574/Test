package synchronizedTest;

import java.util.concurrent.locks.ReentrantLock;

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
