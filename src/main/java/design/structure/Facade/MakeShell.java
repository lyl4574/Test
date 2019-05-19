package design.structure.Facade;

/**
 * 制作手机壳
 */
public class MakeShell implements Make{
    @Override
    public void doMake() {
        System.out.println("make shell");
    }
}
