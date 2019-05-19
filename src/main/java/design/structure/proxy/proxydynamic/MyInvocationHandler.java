package design.structure.proxy.proxydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private FruitFarmer target;
    public MyInvocationHandler(FruitFarmer target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("fdfsd");
        method.invoke(target, args);
        System.out.println("fdfsd1");
        return null;
    }
}
