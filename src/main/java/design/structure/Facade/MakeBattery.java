package design.structure.Facade;

/**
 * 制作电池
 */
public class MakeBattery implements Make{
    @Override
    public void doMake() {
        System.out.println("make battery");
    }
}
