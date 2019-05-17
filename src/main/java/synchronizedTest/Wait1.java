package synchronizedTest;

public class Wait1 {
    private  Object a = new Object();

    public  void method() throws InterruptedException {
        synchronized(a){
            System.out.println("method");
//            a.wait();
            Thread.sleep(2000);
            System.out.println("method end");
//            Wait.class.wait();
        }
    }
    public void method1() throws InterruptedException {
        synchronized(a){
            a.notify();
            System.out.println("method1");
//            Wait.class.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Wait1 wait1 = new Wait1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wait1.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//
        Wait1 wait2 = new Wait1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wait2.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
