package design.factory.abs;

import java.awt.*;

public abstract class MachineFactory {
    abstract Mouse createMouse();
    abstract Keyboard createKeyboard();
}
