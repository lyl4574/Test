package design.structure.Facade;

public class Client {
    public static void main(String[] args) {
        new MakeBattery().doMake();
        new MakeMonitor().doMake();
        new MakeShell().doMake();
        System.out.println("make a phone");
    }
}
