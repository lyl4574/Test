package design.structure.flyweight;

public class Xiaomi implements Mobile {
    private String name;
    public Xiaomi(String name){
        this.name = name;
    }
    @Override
    public String description() {
        return  "xiao mi mobile";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
