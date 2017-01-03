package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
//	private static final int POOL_SIZE=1000;
	private final ExecutorService pool;

    public Client(int poolSize) {
      pool = Executors.newFixedThreadPool(poolSize);
    }
    public static void main(String[] args) {
		Client c = new Client(1);
		long btime = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			c.pool.submit(new Task(i));
		}
		c.pool.shutdown();
		if(c.pool.isShutdown()){
			System.out.println(23);
		}
		System.out.println(System.currentTimeMillis()-btime);
	}
}
