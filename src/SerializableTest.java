import java.io.Serializable;

public class SerializableTest implements Serializable {
    private static final long serialVersionUID = 3755636988287200824L;
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
