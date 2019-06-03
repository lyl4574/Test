package thread.volatileTest;

public class VolatileTest1 {
    private  volatile boolean isRunning = true;
    public void stop(){
        isRunning = false;
        System.out.println("modify running false");
    }
     class Start extends Thread {
        public void run(){
            while (isRunning){
                System.out.println("thread is running"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        VolatileTest1 vt = new VolatileTest1() ;
       vt.new Start().start();
       vt.new Start().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vt.stop();
    }
}
