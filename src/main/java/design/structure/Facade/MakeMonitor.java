package design.structure.Facade;

/**
 * 制作显示屏
 */
public class MakeMonitor implements Make {

    @Override
    public void doMake() {
        System.out.println("make monitor");
    }
}
