import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest extends Thread {

	final static LinkedBlockingQueue<Object> waitingEvents =   new LinkedBlockingQueue<Object>();
	public static void main(String[] args) throws InterruptedException {
//	System.out.println(1<<0);
//	System.out.println(1<<3);
//	System.out.println(1>>3);
		new LinkedBlockingQueueTest().start();
	while(true){
		Object o = waitingEvents.take();
		System.out.println(o.toString());
		Thread.sleep(1000);
	}
	
	}
	public void run() {
		for(int i=0;i<10;i++){
			waitingEvents.add(i);
		}
	}
}
