package rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RPCProxy {
    /**
     * 动态代理完成客户端和服务端的通信
     */
    public static <T> T getRemoteProxy(Class<T> interfaceCls, final InetSocketAddress address){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket();
                socket.connect(address);
                ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream deserializer =  new ObjectInputStream(socket.getInputStream());
                serializer.writeUTF(interfaceCls.getName());
                serializer.writeUTF(method.getName());
                serializer.writeObject(method.getParameterTypes());
                serializer.writeObject(args);
                return deserializer.readObject();
            }
        });
    }
}
