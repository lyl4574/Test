package design.structure.adapter;

/**
 * 升级后也可以听音乐
 */
public class UpgradeClient {
    public static void main(String[] args) {
        // 一根充电线
        Charging charging = new ChargingImpl();
        // 一个耳机
        ListenMusic listenMusic = new ListenMusicImpl();
        // 一个耳机适配器
        Charging listenMusicAdapter = new ListenMusicAdapter(listenMusic);
        XiaoMi xiaoMi = new XiaoMi(charging);
        xiaoMi.charge();
        xiaoMi.setCharging(listenMusicAdapter);
        xiaoMi.charge();
    }
}
