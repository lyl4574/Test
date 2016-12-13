package zookeeper;

  
import java.io.IOException;  
  
import org.apache.zookeeper.CreateMode;  
import org.apache.zookeeper.KeeperException;  
import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.ZooDefs.Ids;  
import org.apache.zookeeper.ZooKeeper;  
  
public class SetConfig {  
    public static String url="127.0.0.1:2181";//连接服务器,2181是端口号，服务器会监视此端口  
    private final static String root="/myConf";  
      
    //数据库连接URL,username,password  
    private final static String urlNode=root+"/url";  
    private final static String usernameNode=root+"/username";  
    private final static String passwordNode=root+"/password";  
      
    //在cli界面这样访问权限：addauth digest password /myConf  
    private final static String auth_type="digest";  
    private final static String auth_password="password";  
      
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException  
    {  
        ZooKeeper zk=new ZooKeeper(url, 3000, new Watcher(){  
  
            @Override  
            public void process(WatchedEvent event) {  
                System.out.println("触发了事件："+event.getType());  
            }             
        });  
          
        while(ZooKeeper.States.CONNECTED!=zk.getState())  
        {  
            Thread.sleep(3000);  
        }  
        //加密操作，对一个session下创建的path进行加密，通常和CREATOR_ALL_ACL一起用  
        zk.addAuthInfo(auth_type, auth_password.getBytes());  
          
        if(zk.exists(root, true)==null)//判断某个path是否存在，并设置是否监控这个目录节点  
        {  
            zk.create(root, "root".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);  
        }  
        if(zk.exists(urlNode, true)==null)  
        {  
            zk.create(urlNode, "202.101.1.1".getBytes(),Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);  
        }  
        if(zk.exists(usernameNode, true)==null)  
        {  
            zk.create(usernameNode, "wangfan".getBytes(),Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);  
        }  
        if(zk.exists(passwordNode,true)==null)  
        {  
            zk.create(passwordNode, "michael".getBytes(),Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);  
        }  
        zk.close();  
    }  
}
