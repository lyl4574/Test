package other.string;

/**
 * 连接表达式 +
 * （1）只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
 * （2）对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中。
 */
public class StringSpecial {
    public static final String A = "ab"; // 常量A
    public static final String B = "cd"; // 常量B

    public static final String C; // 常量C
    public static final String D; // 常量D
    static {
        C = "ab";
        D = "cd";
    }
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        System.out.println(str3 == str4);//false

        String str5 = "string";
        System.out.println(str3 == str5);//true

        //特例
        String s = A + B;  // 将两个常量用+连接对s进行初始化
        String t = "abcd";
        if (s == t) {
            System.out.println("s等于t，它们是同一个对象");
        } else {
            System.out.println("s不等于t，它们不是同一个对象");
        }

        //特例
        String m = C + D;  // 将两个常量在编译阶段没有初始化，在运行期间才赋值。
        if (m == t) {
            System.out.println("m等于t，它们是同一个对象");
        } else {
            System.out.println("m不等于t，它们不是同一个对象");
        }
    }

}
