package volatileTest;

/*
线程安全: 在多线程中使用时,不用自已做同步处理.   
线程不安全: 在多线程中使用时, 必须做线程同步,不然会有未知后果.
线程的工作原理，jvm有一个main memory，而每个线程有自己的working memory，一个线程对一个variable进行操作时，
都要在自己的working memory里面建立一个copy，操作完之后再写入main memory。
多个线程同时操作同一个variable，就可能会出现不可预知的结果。可用synchronized来解决。
而用synchronized的关键是建立一个monitor，这个monitor可以是要修改的variable也可以其他你认为合适的object比如method，
然后通过给这个monitor加锁来实现线程安全，每个线程在获得这个锁之后，要执行完 load到workingmemory －> use&assign －> store到mainmemory 的过程，
才会释放它得到的锁。这样就实现了所谓的线程安全。

例如：vector线程安全 ArrayList非线程安全，但却节约系统性能

比如一个 ArrayList 类，在添加一个元素的时候，它可能会有两步来完成：1. 在 Items[Size] 的位置存放此元素；2. 增大 Size 的值。

在单线程运行的情况下，如果 Size = 0，添加一个元素后，此元素在位置 0，而且 Size=1；
而如果是在多线程情况下，比如有两个线程，线程 A 先将元素存放在位置 0。但是此时 CPU 调度线程A暂停，线程 B 得到运行的机会。线程B也向此 ArrayList 添加元素，因为此时 Size 仍然等于 0 （注意哦，我们假设的是添加一个元素是要两个步骤哦，而线程A仅仅完成了步骤1），所以线程B也将元素存放在位置0。然后线程A和线程B都继续运行，都增加 Size 的值。
那好，现在我们来看看 ArrayList 的情况，元素实际上只有一个，存放在位置 0，而 Size 却等于 2。这就是“线程不安全”了，呵呵。

vector 添加元素方法有synchronized修饰
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
