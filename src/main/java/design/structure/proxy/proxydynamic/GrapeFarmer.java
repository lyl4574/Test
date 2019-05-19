package design.structure.proxy.proxydynamic;

public class GrapeFarmer implements FruitFarmer {
    @Override
    public void sell() {
        System.out.println("GrapeFarmer sell grape");
    }

    @Override
    public void print() {
        System.out.println("I am a sale of GrapeFarmer ");
    }
}
