package rpc.server;

import rpc.common.MobilePrice;

public class MobilePriceImpl implements MobilePrice {
    @Override
    public int getPriceByName(String name) {
        return name.equals("apple")?50:100;
    }
}
