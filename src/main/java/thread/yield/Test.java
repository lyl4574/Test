package thread.yield;

/**
 * Java线程：线程的调度-让步
 * Sleep:会让当前线程休眠进入阻塞状态并释放CPU
 *
 * yield:让出CPU调度，Thread类的方法，类似sleep只是不能由用户指定暂停多长时间 ，并且yield()方法只能让同优先级的线程有执行的机会。
 * yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。调用yield方法只是
 * 一个建议，告诉线程调度器我的工作已经做的差不多了，可以让别的相同优先级的线程使用CPU了，没有任何机制保证采纳。
*/   
public class Test {   
        public static void main(String[] args) throws InterruptedException {
                Thread t1 = new MyThread1();   
                Thread t2 = new Thread(new MyRunnable());   
  
                t2.start();   
                t1.start();
//                Thread.sleep(3000);
                Thread t3 = new MyThread1();
                t3.start();
        }   
}   
  
class MyThread1 extends Thread {   
        public void run() {   
                for (int i = 0; i < 10; i++) {   
                        System.out.println("线程1第" + i + "次执行！");   
                }   
        }   
}   
  
class MyRunnable implements Runnable {   
        public void run() {   
                for (int i = 0; i < 10; i++) {   
                        System.out.println("线程2第" + i + "次执行！");   
                        Thread.yield();   
                }   
        }   
}  