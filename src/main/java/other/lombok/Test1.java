package other.lombok;

import lombok.Data;

public class Test1 {
    public static void main(String[] args) {
        A a = new A(1);
        A b = new A(1);
        // 继承自Object的equals 方法，比较的是内存地址，所以不相等
        System.out.println(a.equals(b));
    }
}
class A {
    private int id;
    private String code;
    public A(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
