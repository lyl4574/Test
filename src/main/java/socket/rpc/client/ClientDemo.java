package socket.rpc.client;

import socket.rpc.common.MobilePrice;

import java.net.InetSocketAddress;

public class ClientDemo {
    public static void main(String[] args) {
        MobilePrice mobilePrice = RPCProxy.getRemoteProxy(MobilePrice.class,new InetSocketAddress(12345));
        System.out.println("" + mobilePrice.getPriceByName("apple"));
    }
}
