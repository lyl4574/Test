package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class Test {
	   public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//		   String exec[] = new String[1];
//	       System.out.println("map:"+System.getenv());
//	        Runtime.getRuntime().exec("notepad.exe D:\\a.txt");
	        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",   
	                9999, new Watcher() {   
	                       // 监控所有被触发的事件  
	                       public void process(WatchedEvent event) {   
	                           System.out.println("已经触发了" + event.getType() + "事件！");   
	                       }

	                   });   
	        zk.create("/pp3", "14".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
	   }
}
