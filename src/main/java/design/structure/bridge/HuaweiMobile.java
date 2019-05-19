package design.structure.bridge;

/**
 * refined abstract
 */
public class HuaweiMobile extends AbstractMobile{
    public HuaweiMobile(Headset headset){
        super(headset);
    }
    @Override
    void insertHeadset() {
        this.getHeadset().listen();
    }
}
