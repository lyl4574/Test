package design.structure.bridge;

public class XiaomiMobile extends AbstractMobile {
    public XiaomiMobile(Headset headset){
        super(headset);
    }
    @Override
    void insertHeadset() {
        this.getHeadset().listen();
    }
}
