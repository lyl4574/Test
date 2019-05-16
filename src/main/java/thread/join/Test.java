package thread.join;

/**
 *  join “等待该线程终止。”
 * 解释一下，是主线程等待子线程的终止。也就是说主线程的代码块中，如果碰到了t.join()方法，此时主线程需要等待（阻塞），
 * 等待子线程结束了(Waits for this thread to die.),才能继续执行t.join()之后的代码块。
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am running");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am running now");
            }
        });
//        Thread.currentThread().join();
        thread.start();
        thread.join();
        Thread thread1 = new Thread1();
        thread1.start();
    }
    static class Thread1 extends Thread{
        public void run(){
            System.out.println("thread1 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 am running now");
        }
    }
}
