package design.structure.adapter;

/**
 * 充电实现类
 */
public class ChargingImpl implements Charging{
    @Override
    public void charging() {
        System.out.println("mobile is charging");
    }
}
