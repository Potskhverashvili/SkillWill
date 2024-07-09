import calculator.Calculator;
import display.ShapeInformation;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

public class Main {
    public static void main(String[] args) {

        // Create instances of Calculator and ShapeInformation
        Calculator calculator = new Calculator();
        ShapeInformation shape = new ShapeInformation();

        // Create shape objects
        Shape rectangle = new Rectangle(4, 7);
        Shape circle = new Circle(5);

        // Calculate and display the area of the rectangle
        System.out.println(shape.getShapeType(rectangle) + " area: " + rectangle.calculateArea());

        // Calculate and display the area of the circle
        System.out.println(shape.getShapeType(rectangle) + " area: " + calculator.calculateArea(circle));
    }
}