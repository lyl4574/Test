package thread.synchronizedTest;

import java.util.concurrent.Semaphore;
/*
信号量维护一个许可集，可通过acquire()获取许可（若无可用许可则阻塞），
通过release()释放许可，从而可能唤醒一个阻塞等待许可的线程。

与互斥锁类似，信号量限制了同一时间访问临界资源的线程的个数，并且信号量也分公平信号量与非公平信号量。
而不同的是，互斥锁保证同一时间只会有一个线程访问临界资源，而信号量可以允许同一时间多个线程访问特定资源。所以信号量并不能保证原子性。
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // true 公平锁， 按顺序获取锁 false 非公平锁，随机获取锁。默认false
        Semaphore  semaphore = new Semaphore(4,true);
        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"begin");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"end");
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
