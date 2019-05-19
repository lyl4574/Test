package design.structure.decorator;

/*
装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。
这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。

这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。

何时使用：在不想增加很多子类的情况下扩展类。
如何解决：将具体功能职责划分，同时继承装饰者模式。

装饰器模式：能动态的新增或组合对象的行为
在不改变接口的前提下，动态扩展对象的功能

代理模式：为其他对象提供一种代理以控制对这个对象的访问
在不改变接口的前提下，控制对象的访问
 */
public class DecoratorPatternDemo {
   public static void main(String[] args) {
 
      Shape circle = new Circle();

      Shape redCircle = new ColorShapeDecorator(new Circle(),"red");
 
      Shape blueRectangle = new ColorShapeDecorator(new Rectangle(),"blue");
      System.out.println("Circle with normal border");
      circle.draw();
 
      System.out.println("\nCircle of red border");
      redCircle.draw();
 
      System.out.println("\nRectangle of red border");
      blueRectangle.draw();
   }
}