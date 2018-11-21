package algorithm.cache;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*add ,remove ,element 会抛出异常，offer，poll，peek 不会。

        LinkedBlockingQueue
add(e) remove() element() 方法不会阻塞线程。当不满足约束条件时，会抛出IllegalStateException 异常。例如：当队列被元素填满后，再调用add(e)，则会抛出异常。
offer(e) poll() peek() 方法也不会阻塞线程，也不会抛出异常。例如：当队列被元素填满后，再调用offer(e)，则不会插入元素，函数返回false。
要想要实现阻塞功能，需要调用put(e) take() 方法。当不满足约束条件时，会阻塞线程。
*/
public class QueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
//        queue.add(4);
//        queue.add(5);
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.size());
    }
}
