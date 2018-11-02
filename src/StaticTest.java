public class StaticTest {
    private static int a=0;
    private static ClassTest ct = new ClassTest();

    public static void main(String[] args) {
        StaticTest a =  new StaticTest();
        StaticTest b =  new StaticTest();
        a.a++;
        System.out.println(a.a);
        System.out.println(b.a);
        System.out.println(StaticTest.a);

//        a.ct = new ClassTest();
        a.ct.setB(1);
        System.out.println(a.ct.getB());
        System.out.println(b.ct.getB());
        System.out.println(StaticTest.ct.getB());
    }
}
class ClassTest{
    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
