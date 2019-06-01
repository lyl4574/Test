package rpc.server;

import design.structure.flyweight.Mobile;
import rpc.common.MobilePrice;

public class Demo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Server server = new Server();
        server.registerService(MobilePrice.class,MobilePriceImpl.class);
        server.start(12345);
    }
}
