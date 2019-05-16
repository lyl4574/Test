package thread.join;

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
//        thread.join();
//        Thread thread1 = new Thread1();
//        thread1.start();
//        thread1.join();
//        Thread.currentThread().join();
    }
    static class Thread1 extends Thread{
        public void run(){
            System.out.println("thread1 is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 am running now");
        }
    }
}
