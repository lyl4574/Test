/**
 * 自动拆箱
 * 类型       相同对象范围       不同对象范围
 * Integer    [-128，128）     i>=128 ||i<-128
 * Short      [-128，128）     s>=128 ||s<-128
 * Character  c<128            c>=128
 * Long       [-128，128）     v>=128 ||v<-128
 * Boolean   true,false
 * Double     没有
 */
public class AutoBox {
    public static void main(String[] args) {
        Short a=23;
        Short b=23;
        Short c=128;
        Short d=128;
        Boolean f=true;
        Boolean g=true;
        Integer h= 400;
        int m=400;
        Integer n= 400;
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(f==g);
        //当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，对基础数据类型进行运算。
        System.out.println(h==m);
        System.out.println(h==n);
        System.out.println(n==m);

        Integer x=500;
        int y=500;
        int z = 500;
        System.out.println(x==y);
        System.out.println(y==z);
        System.out.println(x.equals(y));
        System.out.println(x.hashCode());
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));
    }
}
