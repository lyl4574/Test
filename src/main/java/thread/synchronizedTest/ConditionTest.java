package thread.synchronizedTest;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ConditionTest {
  public static void main(String[] args) throws InterruptedException {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    new Thread(() -> {
      lock.lock();
      try {
        System.out.println(new Date() + "\tThread 1 is waiting");
        try {
          //await()操作实际上就是释放锁，然后挂起线程，一旦条件满足就被唤醒，再次获取锁！
          long waitTime = condition.awaitNanos(TimeUnit.SECONDS.toNanos(2));
          System.out.println(new Date() + "\tThread 1 remaining time " + waitTime);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        System.out.println(new Date() + "\tThread 1 is waken up");
      } finally {
        lock.unlock();
      }
    }).start();
    
    new Thread(() -> {
      lock.lock();
      try{
        System.out.println(new Date() + "\tThread 2 is running");
        try {
          Thread.sleep(4000);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        condition.signal();
        System.out.println(new Date() + "\tThread 2 ended");
      } finally {
        lock.unlock();
      }
    }).start();
  }
}