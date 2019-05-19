package design.structure.adapter;

/**
 * 原始类不可变化
 * XiaoMi，Charging，ChargingImpl类都是不可变的
 */
public class XiaoMi {
    private  Charging charging;
    public XiaoMi(Charging charging){
        this.charging = charging;
    }
    public void charge(){
        charging.charging();
    }
    public void setCharging(Charging charging) {
        this.charging = charging;
    }
}
