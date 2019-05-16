package design.create.factory.abs;

public class HpFactory extends MachineFactory {
    @Override
    Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
