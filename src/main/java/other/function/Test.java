package other.function;

/**
 * 表达式:
 * person -> person.getAge();
 * 可以替换成
 * Person::getAge
 * 方法引用Person::getAge就对应着Function<Person,Integer>类型。
 *
 * 表达式
 * () -> new HashMap<>();
 * 可以替换成
 * HashMap::new
 */
public class Test {
    public static void main( String[] args ) {
        Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        System.out.println( defaulable.notRequired() );

        defaulable = DefaulableFactory.create( OverridableImpl::new );
        System.out.println( defaulable.notRequired() );
    }
}
