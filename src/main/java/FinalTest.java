import java.util.HashMap;
import java.util.Map;
/* final 类型 指内存中所指向的内存地址是不可变的。
    map和arrList中 put 或添加数据并不是修改原有变量的内存指向地址。只是给这个地址中加了更多的值而已。
 */

public class FinalTest {
    public void finalMethod(final Map a){
        a.put("s",1);
        System.out.println(a);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a",2);
        new FinalTest().finalMethod(map);
    }
}
