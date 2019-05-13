/**
 * Test2中的静态代码块是没有运行的，因为Test2并没有初始化
 * 注意，这里的final关键字不可缺少，我们知道变量被关键字fianl修饰之后就不可修改，亦即此变量相当于编译期常量（是相当于并非就是常量），
 * 常量在java编译期已经确定，不需要初始化，但是把fianal去掉，或者把 final int n = 2 改为 final int n = new Random（）。，
 * 运行的结果将变为 test  ，2 ，因为n的值为变量或者n值在编译期不能确定，就必须经过初始化才能使用n的值
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Test2.n);
    }
}

class Test2 {
    public static final int n = 2;

    static {
        System.out.println("test");
    }
}