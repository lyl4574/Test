package other.value.transfer;

/**
 * java 值传递
 */
public class Test {
    private static int x=10;

    public static void updateBaseValue(int value){
        value = 3 * value;
    }

    private static String str="a";

    public static void updateStringValue(String value){
        value = str+"b";
    }

    public static void updateObjectValue(Student student){
        student.setName("lyl");
    }

    public static void main(String[] args) {
        System.out.println("调用前x的值：" + x);
        updateBaseValue(x);
        System.out.println("调用后x的值：" + x);
        System.out.println("调用前str的值：" + str);
        updateStringValue(str);
        System.out.println("调用后str的值：" + str);
        Student student = new Student("ly");
        System.out.println("调用前student的值：" + student.getName());
        updateObjectValue(student);
        System.out.println("调用后str的值：" + student.getName());
    }
    static class  Student{
        String name;
        public Student(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
