package rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 服务提供方
 */
public class Server {
    /**
     * 服务注册中心
     * serviceMap key:接口 value：服务具体实现类
     */
    private final Map< String, Object> serviceMap = new ConcurrentHashMap< String, Object>(256);

    /**
     * 注册服务方法
     *
     * @param interfaceName 服务接口
     * @param implClass         具体实现类
     */
    public void registerService(Class<?> interfaceName, Class<?> implClass) throws IllegalAccessException, InstantiationException {
        serviceMap.put(interfaceName.getName(), implClass.newInstance());
    }

    /**
     * 多线程处理服务请求
     */
    private final ExecutorService executorService = new ThreadPoolExecutor(10,
            100, 10,TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    /**
     * 服务启动
     *
     * @param port
     */
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("server start");
            while (true){
                executorService.submit(new ServerTask(serverSocket.accept()));
            }

        } catch (IOException e) {
            throw new RuntimeException("服务启动异常",e);
        }
    }

    class ServerTask implements Runnable{
        private final Socket client;
        public ServerTask(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                // 约定序列化方式
                ObjectInputStream deserializer =  new ObjectInputStream(client.getInputStream());
                ObjectOutputStream serializer = new ObjectOutputStream(client.getOutputStream());
                //接口
                String serviceName = deserializer.readUTF();
                //方法
                String methodName = deserializer.readUTF();
                //参数类型
                Class<?>[] paramTypes = (Class<?>[]) deserializer.readObject();
                //参数
                Object [] parameters = (Object []) deserializer.readObject();

                Object instance = serviceMap.get(serviceName);
                if(instance == null){
                    throw new RuntimeException("未找到相关服务");
                }
                Method method = instance.getClass().getDeclaredMethod(methodName,paramTypes);
                Object result = method.invoke(instance,parameters);
                serializer.writeObject(result);
            } catch (Exception e) {
                throw new RuntimeException("网络传输中异常",e);
            }
        }
    }

}
