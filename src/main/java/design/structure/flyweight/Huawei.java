package design.structure.flyweight;

public class Huawei implements Mobile {
    private String name;
    public Huawei(String name){
        this.name = name;
    }
    @Override
    public String description() {
        return "hua wei mobile";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
