package volatileTest;

public class VolatileTest1 {
    private static boolean isRunning = false;
    static class Stop extends Thread {
        public void run(){
            try {
                Thread.sleep(1000);
                isRunning = false;
                System.out.println("thread is stop"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Start extends Thread {
        public void run(){
            isRunning = true;
            while (isRunning){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread is running"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        new Start().start();
        new Stop().start();
    }
}
