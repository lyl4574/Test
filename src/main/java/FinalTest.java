import java.util.HashMap;
import java.util.Map;
/* final 类型 指内存中所指向的内存地址是不可变的。
    map和arrList中 put 或添加数据并不是修改原有变量的内存指向地址。只是给这个地址中加了更多的值而已。
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