package design.factory.abs;

public class DellFactory extends MachineFactory{
    @Override
    Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
