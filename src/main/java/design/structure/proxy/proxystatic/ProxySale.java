package design.structure.proxy.proxystatic;

public class ProxySale implements FruitFarmer {

    private FruitFarmer fruitFarmer;
    public ProxySale(FruitFarmer fruitFarmer){
        this.fruitFarmer = fruitFarmer;
    }

    @Override
    public void sell() {
        fruitFarmer.sell();
        System.out.println("i can do more");
    }
}
