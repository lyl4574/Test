package design.proxy.cglib;

/*
　静态代理和动态代理模式都是要求目标对象实现一个接口或者多个接口,
  但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,
  这个时候就可以使用构建目标对象子类的方式实现代理,这种方法就叫做:Cglib代理

　　Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,
例如Spring AOP和synaop,为他们提供方法的interception(拦截)
Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的子类.

代理的类不能为final,否则报错；目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.

AOP（AspectOrientedProgramming）：
　　将日志记录，性能统计，安全控制，事务处理，异常处理等代码从业务逻辑代码中划分出来，通过对这些行为的分离，
我们希望可以将它们独立到非业务逻辑的方法中，进而改变这些行为的时候不影响业务逻辑的代码---解耦。
**
在Spring的AOP编程中:
如果加入容器的目标对象有实现接口,用JDK代理
如果目标对象没有实现接口,用Cglib代理**

装饰器模式：能动态的新增或组合对象的行为
在不改变接口的前提下，动态扩展对象的功能

代理模式：为其他对象提供一种代理以控制对这个对象的访问
在不改变接口的前提下，控制对象的访问
 */
public class Main {
    public static void main(String[] args) {
        AppleFarmer appleFarmer = new AppleFarmer();
        AppleFarmer proxy = (AppleFarmer)new ProxyFactory(appleFarmer).getProxyInstance();
        proxy.sell();
        proxy.print();
    }
}
