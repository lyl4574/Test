package design.proxy.proxystatic;

public class GrapeFarmer implements FruitFarmer {
    @Override
    public void sell() {
        System.out.println("GrapeFarmer sell grape");
    }
}
