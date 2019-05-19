package design.structure.bridge;

/**
 * client 测试类
 */
public class Client {
    public static void main(String[] args) {
        XiaomiHearSet xiaomiHearSet = new XiaomiHearSet();
        HuaweiHearSet huaweiHearSet = new HuaweiHearSet();
        new HuaweiMobile(huaweiHearSet).insertHeadset();
        new XiaomiMobile(xiaomiHearSet).insertHeadset();
    }
}
