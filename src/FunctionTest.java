import java.util.function.Function;

public class FunctionTest {
    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        int a=10;
        modifyTheValue(10,x->x+10);

    }
}
