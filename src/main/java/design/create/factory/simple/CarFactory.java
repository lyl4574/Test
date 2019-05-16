package design.create.factory.simple;

public class CarFactory {
    String color;
    public CarFactory(String color){
        this.color = color;
    }
    public Car createCar(){
        if(color.equals("red")){
            return new RedCar();
        }
        if(color.equals("blue")){
            return  new BlueCar();
        }
        return null;
    }

    public static void main(String[] args) {
        new CarFactory("red").createCar();
        new CarFactory("blue").createCar();
        System.out.println((new RedCar().equals(new RedCar())));
    }
}
