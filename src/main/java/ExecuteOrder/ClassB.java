package ExecuteOrder;

public class ClassB extends ClassA{
    
    
    static{
        System.out.println("ClassB的静态代码块");
    }
    
    public ClassB(){
        System.out.println("ClassB的构造方法");
    }
    
    public void excute(){
        System.out.println("执行方法");
    }

}