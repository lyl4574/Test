import java.util.HashMap;
import java.util.Map;
/**
 * 8种基本类型的常量池都是系统协调的，String类型的常量池比较特殊。它的主要使用方法有两种：
 * 直接使用双引号声明出来的String对象会直接存储在常量池中。
 * 如果不是用双引号声明的String对象，可以使用String提供的intern方法。intern 方法会从字符串常量池中查询当前字符串是否存在，
 * 若不存在就会将当前字符串放入常量池中
 *
 *  final 类型 指内存中所指向的内存地址是不可变的。
 *  map和arrList中 put 或添加数据并不是修改原有变量的内存指向地址。只是给这个地址中加了更多的值而已。
 *
 *  Class文件中的常量池
 * 在Class文件结构中，最头的4个字节用于存储魔数Magic Number，用于确定一个文件是否能被JVM接受，再接着4个字节用于存储版本号，
 * 前2个字节存储次版本号，后2个存储主版本号，再接着是用于存放常量的常量池，由于常量的数量是不固定的，所以常量池的入口放置一
 * 个U2类型的数据(constant_pool_count)存储常量池容量计数值。
 * 常量池主要用于存放两大类常量：字面量(Literal)和符号引用量(Symbolic References)，字面量相当于Java语言层面常量的概念，如
 * 文本字符串，声明为final的常量值等，符号引用则属于编译原理方面的概念，包括了如下三种类型的常量：
 * 1、类和接口的全限定名
 * 2、字段名称和描述符
 * 3、方法名称和描述符
 *
 * 方法区中的运行时常量池
 * 运行时常量池是方法区的一部分。
 * CLass文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池，用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存放。
 * 运行时常量池相对于CLass文件常量池的另外一个重要特征是具备动态性，Java语言并不要求常量一定只有编译期才能产生，也就是并非预置入CLass文件中常量池的内容才能进入方法区运行时常量池，运行期间也可能将新的常量放入池中，这种特性被开发人员利用比较多的就是String类的intern()方法。
 *
 * 常量池的好处
 * 常量池是为了避免频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
 * 例如字符串常量池，在编译阶段就把所有的字符串文字放到一个常量池中。
 * （1）节省内存空间：常量池中所有相同的字符串常量被合并，只占用一个空间。
 * （2）节省运行时间：比较字符串时，==比equals()快。对于两个引用变量，只用==判断引用是否相等，也就可以判断实际值是否相等。
 */

public class FinalTest {
    private final Integer m = 300;
    private final Integer n = 300;
    private final String str1 = "we";
    private  String str2 = "we";

    private final A2 a1 = new A2();
    private final A2 a2 = new A2();

    public void finalMethod(final Map a) {
        a.put("s", 1);
        System.out.println(a);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a", 2);
        new FinalTest().finalMethod(map);
        //单个实例验证 final
        FinalTest finalTest1 = new FinalTest();
        System.out.println(finalTest1.m == finalTest1.n);
        System.out.println(finalTest1.str1 == finalTest1.str2);
        System.out.println(finalTest1.a1 == finalTest1.a2);

        //多个实例验证 final, 每次实例化，都会生成自己的final 常量池，除了基本数据类型和string是全局的常量池。
        FinalTest finalTest2 = new FinalTest();
        System.out.println(finalTest1.m == finalTest2.m);
        System.out.println(finalTest1.str1 == finalTest2.str2);
        System.out.println(finalTest1.a1 == finalTest2.a1);
        System.out.println(finalTest1.str1 == finalTest2.a1.getName());
//
        //equals ture，hashCode 就相等
        System.out.println(finalTest1.m.hashCode());
        System.out.println(finalTest1.n.hashCode());
        //== true，内存地址才相等。
        System.out.println(System.identityHashCode(finalTest1.m));
        System.out.println(System.identityHashCode(finalTest1.n));
    }
}
 class A2{
    private Integer id;
     private String name="we";

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }