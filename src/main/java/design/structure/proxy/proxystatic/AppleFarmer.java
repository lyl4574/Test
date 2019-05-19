package design.structure.proxy.proxystatic;

public class AppleFarmer implements FruitFarmer {
    @Override
    public void sell( ) {
        System.out.println("AppleFarmer sell apple");
    }
}
