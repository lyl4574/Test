import zookeeper.Executor;

import java.util.concurrent.*;

public class ThreadPoolTest {
    static int count=0;
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                8, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(100), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                System.out.println("queue full ，reject thread task count" + ++count);
            }
        });
        for(int i=0;i<150;i++) {
            poolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}


