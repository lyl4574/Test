package other.lombok;

import lombok.*;

import java.math.BigDecimal;

/**
 * lombok 继承父类，默认equals()、hashcode()、toString()方法不使用父类的属性。
 * 需要@EqualsAndHashCode(callSuper = true)、 @ToString(callSuper = true)注解来引用父类属性
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class XiaoMi extends Mobile{
    private BigDecimal length;
    private BigDecimal high;
}
