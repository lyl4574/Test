
	package zookeeper;  
	  
	import java.io.IOException;  
	  
	import org.apache.zookeeper.KeeperException;  
	import org.apache.zookeeper.WatchedEvent;  
	import org.apache.zookeeper.Watcher;  
	import org.apache.zookeeper.ZooKeeper;  
	  
	public class Client implements Watcher{  
	    public static String url="127.0.0.1:2181";//连接服务器,2181是端口号，服务器会监视此端口  
	      
	    private final static String root="/myConf";  
	      
	    //数据库连接URL,username,password  
	    private  String urlNode=root+"/url";  
	    private  String usernameNode=root+"/username";  
	    private  String passwordNode=root+"/password";  
	      
	    private final static String auth_type="digest";  
	    private final static String auth_password="password";  
	      
	    private String urlString;  
	    private String username;  
	    private String password;  
	      
	    ZooKeeper zk=null;  
	      
	    public String getUrlString() {  
	        return urlString;  
	    }  
	    public void setUrlString(String urlString) {  
	        this.urlString = urlString;  
	    }  
	    public String getUsername() {  
	        return username;  
	    }  
	    public void setUsername(String username) {  
	        this.username = username;  
	    }  
	    public String getPassword() {  
	        return password;  
	    }  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
	      
	    public void initValue() throws KeeperException, InterruptedException  
	    {  
	        urlString=new String(zk.getData(urlNode, false, null));//url变化不会触发事件,getData()方法是获取这个path对应的目录节点存储的数据，同时还可以设置是否监控这个目录节点数据的状态  
	        username=new String(zk.getData(usernameNode, true, null));  
	        password=new String(zk.getData(passwordNode, true, null));  
	    }  
	      
	    public ZooKeeper getZK() throws IOException, InterruptedException  
	    {  
	        zk=new ZooKeeper(url,3000,this);  
	        zk.addAuthInfo(auth_type, auth_password.getBytes());  
	        while(ZooKeeper.States.CONNECTED!=zk.getState())  
	        {  
	            Thread.sleep(3000);  
	        }  
	        return zk;  
	    }  
	      
	    @Override  
	    public void process(WatchedEvent event) {  
	        // TODO 自动生成的方法存根  
	        if(event.getType()==Watcher.Event.EventType.None)  
	        {  
	            System.out.println("连接服务器成功！");  
	        }  
	        else if(event.getType()==Watcher.Event.EventType.NodeCreated)  
	        {  
	            System.out.println("节点创建成功！");  
	        }  
	        else if(event.getType()==Watcher.Event.EventType.NodeChildrenChanged)  
	        {  
	            System.out.println("子节点更新成功！");  
	            //读取新的配置  
	            try {  
	                initValue();  
	            } catch (KeeperException e) {  
	                // TODO 自动生成的 catch 块  
	                e.printStackTrace();  
	            } catch (InterruptedException e) {  
	                // TODO 自动生成的 catch 块  
	                e.printStackTrace();  
	            }  
	        }  
	        else if(event.getType()==Watcher.Event.EventType.NodeDataChanged)  
	        {  
	            System.out.println("节点更新成功！");  
	            //读取新的配置  
	            try {  
	                initValue();  
	            } catch (KeeperException e) {  
	                // TODO 自动生成的 catch 块  
	                e.printStackTrace();  
	            } catch (InterruptedException e) {  
	                // TODO 自动生成的 catch 块  
	                e.printStackTrace();  
	            }  
	        }  
	        else if(event.getType()==Watcher.Event.EventType.NodeDeleted)  
	        {  
	            System.out.println("节点删除成功！");  
	        }  
	    }  
	      
	      
	      
	      
	    public static void main(String[] args) throws IOException, InterruptedException, KeeperException  
	    {  
	        Client zkTest=new Client();  
	        ZooKeeper zk=zkTest.getZK();  
	        zkTest.initValue();  
	        int i=0;  
	        while(true)  
	        {  
	            System.out.println(zkTest.getUrlString());  
	            System.out.println(zkTest.getUsername());  
	            System.out.println(zkTest.getPassword());  
	            System.out.println("-----------------------------------------");  
	            Thread.sleep(10000);  
	            i++;  
	            if(i==10)  
	                break;  
	        }  
	        zk.close();  
	    }  
	      
}
