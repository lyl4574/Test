package design.create.build;

/**
 * 建立复杂对象
 */
public class BeanBuilder {
    private AbstractBean bean;
    public static BeanBuilder genericBean1() {
        BeanBuilder builder = new BeanBuilder();
        builder.bean = new Bean1();
        builder.bean.setField3("bean1");
        return builder;
    }
    public static BeanBuilder genericBean2() {
        BeanBuilder builder = new BeanBuilder();
        builder.bean = new Bean2();
        builder.bean.setField3("bean2");
        return builder;
    }
    public BeanBuilder setField0( String field0){
        this.bean.setField0(field0);
        return  this;
    }
    public BeanBuilder setField1( String field1){
        this.bean.setField1(field1);
        return  this;
    }
    public BeanBuilder setField2( String field2){
        this.bean.setField2(field2);
        return  this;
    }
    public BeanBuilder setField4( String field2){
        this.bean.setField2(field2);
        return  this;
    }
    public BeanBuilder setField3( String field3){
        this.bean.setField3(field3);
        return  this;
    }
    public AbstractBean getBean() {
        return this.bean;
    }

    public static void main(String[] args) {
        System.out.println(new BeanBuilder().genericBean1().setField0("").setField3("32").getBean().toString());
        System.out.println(new BeanBuilder().genericBean2().setField1("").setField3("123").getBean().toString());
    }
}

