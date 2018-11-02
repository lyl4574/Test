/*
线程安全: 在多线程中使用时,不用自已做同步处理.   
线程不安全: 在多线程中使用时, 必须做线程同步,不然会有未知后果.
线程的工作原理，jvm有一个main memory，而每个线程有自己的working memory，一个线程对一个variable进行操作时，
都要在自己的working memory里面建立一个copy，操作完之后再写入main memory。
多个线程同时操作同一个variable，就可能会出现不可预知的结果。可用synchronized来解决。
而用synchronized的关键是建立一个monitor，这个monitor可以是要修改的variable也可以其他你认为合适的object比如method，
然后通过给这个monitor加锁来实现线程安全，每个线程在获得这个锁之后，要执行完 load到workingmemory －> use&assign －> store到mainmemory 的过程，
才会释放它得到的锁。这样就实现了所谓的线程安全。
*/
/*
    volatile 修饰的变量，只能有一个线程修改，多线程读，否则不适用。一改多读。
    下面例子循环使得jvm无暇 缓存同步主存
*/
public class VolatileTest {
    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
                    System.out.println("Got Change for MY_INT : "+MY_INT);
                    local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                System.out.println( "Incrementing MY_INT to "+(local_value+1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
