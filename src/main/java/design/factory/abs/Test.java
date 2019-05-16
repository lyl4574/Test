package design.factory.abs;

public class Test {
    public static void main(String[] args) {
        new HpFactory().createKeyboard();
        new HpFactory().createMouse();
        new DellFactory().createKeyboard();
        new DellFactory().createMouse();
    }
}
