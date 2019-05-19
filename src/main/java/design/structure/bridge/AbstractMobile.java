package design.structure.bridge;

/**
 * 桥接类
 */
abstract class AbstractMobile {
    private Headset headset;
    public AbstractMobile(Headset headset){
        this.headset = headset;
    }
    abstract void insertHeadset();

    public Headset getHeadset() {
        return headset;
    }

    public void setHeadset(Headset headset) {
        this.headset = headset;
    }
}
