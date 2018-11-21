package design.decorator;

public class ColorShapeDecorator extends ShapeDecorator {
   private String color;
   public ColorShapeDecorator(Shape decoratedShape,String color) {
      super(decoratedShape);
      this.color = color;
   }
 
   @Override
   public void draw() {
      decoratedShape.draw();         
      setBorder(this.color);
   }
 
   private void setBorder(String color){
      System.out.println("Border Color: " + color );
   }
}