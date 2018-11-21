package design.proxy.proxystatic;
/*
静态代理
可以做到在不修改目标对象的功能前提下,对目标功能扩展.
缺点:
代理类和委托类实现相同的接口，同时要实现相同的方法。这样就出现了大量的代码重复。
如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
*/
public class Main {
    public static void main(String[] args) {
        new ProxySale(new AppleFarmer()).sell();
        new ProxySale(new GrapeFarmer()).sell();
    }
}
