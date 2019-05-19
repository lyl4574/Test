package design.structure.flyweight;

/**
 * 享元模式以共享的方式高效地支持大量的细粒度对象。
 */
public class Client {
    public static void main(String[] args) {
        Huawei huawei = new Huawei("huawei Pro");
        Huawei huawei1 = new Huawei("huawei horor");
        Huawei huawei2 = new Huawei("huawei horor");
        System.out.println(MobileDescriptionFactory.getDescrition(huawei));
        System.out.println(MobileDescriptionFactory.getDescrition(huawei1));
        System.out.println(MobileDescriptionFactory.getDescrition(huawei2));
    }
}
