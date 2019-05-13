package other;
/**
 * 直接使用双引号声明出来的String对象会直接存储在常量池中(hash table 结构)。
 * String str = new String("a");是生成了两个变量，一个在heap，一个在常量池。str 引用的是heap 中地址。
 * 考虑类加载阶段和实际执行时。
 * （1）类加载对一个类只会进行一次。"xyz"在类加载时就已经创建并驻留了（如果该类被加载之前已经有"xyz"字符串被驻留过则不需
 * 要重复创建用于驻留的"xyz"实例）。驻留的字符串是放在全局共享的字符串常量池中的。
 * （2）在这段代码后续被运行的时候，"xyz"字面量对应的String实例已经固定了，不会再被重复创建。所以这段代码将常量池中的对象
 * 复制一份放到heap中，并且把heap中的这个对象的引用交给s1 持有。
 *
 * 如果不是用双引号声明的String对象，可以使用String提供的intern方法。intern 方法会从字符串常量池中查询当前字符串是否存在，
 * 若不存在就会将当前字符串放入常量池中
 */
//在 jdk7 的版本中，字符串常量池已经从 Perm 区移到正常的 Java Heap 区域了.

/**
 * 在第一段代码中，先看 s3和s4字符串。String s3 = new String("1") + new String("1");，这句代码中现在生成了2最终个对象，
 * 是字符串常量池中的“1” 和 JAVA Heap 中的 s3引用指向的对象。中间还有2个匿名的new String("1")我们不去讨论它们。此时s3
 * 引用对象内容是”11”，但此时常量池中是没有 “11”对象的。
 *
 * 接下来s3.intern();这一句代码，是将 s3中的“11”字符串放入 String 常量池中，因为此时常量池中不存在“11”字符串，因此常
 * 规做法是跟 jdk6 图中表示的那样，在常量池中生成一个 “11” 的对象，关键点是 jdk7 中常量池不在 Perm 区域了，这块做了调
 * 整。常量池中不需要再存储一份对象了，可以直接存储堆中的引用。这份引用指向 s3 引用的对象。 也就是说引用地址是相同的。
 *
 * 最后String s4 = "11"; 这句代码中”11”是显示声明的，因此会直接去常量池中创建，创建的时候发现已经有这个对象了，此时也
 * 就是指向 s3 引用对象的一个引用。所以 s4 引用就指向和 s3 一样了。因此最后的比较 s3 == s4 是 true。
 */
public class StringIntern {
    public static void main(String[] args) {

        String s = new String("1");

        s.intern();
        String s2 = "1";
        //查看常量池中存在了"1";
//        s.intern();
        //引用不一样，false
        System.out.println(s == s2);


        String s3 = new String("1") + new String("1");
//        s3.intern();
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
