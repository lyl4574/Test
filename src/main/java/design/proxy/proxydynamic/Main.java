package design.proxy.proxydynamic;

import java.lang.reflect.Proxy;
/*
动态代理相对 静态代理优势：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 */
public class Main {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new AppleFarmer());
        FruitFarmer fruitFarmerProxy = (FruitFarmer) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{FruitFarmer.class},myInvocationHandler);
        fruitFarmerProxy.print();
        fruitFarmerProxy.sell();
    }
}
