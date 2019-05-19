package design.structure.Facade;

public class Facade {
    private final static MakeBattery MAKE_BATTERY = new MakeBattery();
    private final static MakeMonitor MAKE_MONITOR = new MakeMonitor();
    private final static MakeShell MAKE_SHELL = new MakeShell();
    public void doMake(){
        MAKE_BATTERY.doMake();
        MAKE_MONITOR.doMake();
        MAKE_SHELL.doMake();
        System.out.println("make a mobile");
    }
}
