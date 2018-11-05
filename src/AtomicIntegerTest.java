import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
/* java 8 及以上推荐使用 LongAdder
锁和synchronized需要通过操作系统来仲裁谁获得锁，开销比较高，
        而AtomicInteger是通过CPU级的CAS操作来保证原子性，
        开销比较小。所以使用AtomicInteger的目的还是为了提高性能。
        */
public class AtomicIntegerTest {
    private static int int_count =0;
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        LongAdder long_count = new LongAdder();

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<1000;j++) {
                        count.addAndGet(1);
                        int_count++;
                        long_count.add(1);
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        System.out.println(int_count);
        System.out.println(long_count);
    }
}
