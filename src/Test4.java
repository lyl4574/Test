public class Test4 {
    static boolean foo(char c) {
       System.out.print(c);
       return true;
    }
    public static void main(String[] argv) {
       int n = 2;
       //for(65;88&&(i<2);67)
       n |= n >>> 16;
       System.out.println(n);
    }
}