package design.structure.Facade;

/**
 * 使用facade后客户端访问
 */
public class UpgradeClient {
    public static void main(String[] args) {
        new Facade().doMake();
    }
}
