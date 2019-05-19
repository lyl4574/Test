package design.structure.adapter;

/**
 * 在适配器前只可以client端进行充电
 */
public class Client {
    public static void main(String[] args) {
        Charging charging = new ChargingImpl();
        XiaoMi xiaoMi = new XiaoMi(charging);
        xiaoMi.charge();
    }
}
