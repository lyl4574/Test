package design.proxy.proxydynamic;


public class AppleFarmer implements FruitFarmer {
    @Override
    public void sell( ) {
        System.out.println("AppleFarmer sell apple");
    }
    @Override
    public void print( ) {
        System.out.println("I am a sale of AppleFarmer ");
    }
}
