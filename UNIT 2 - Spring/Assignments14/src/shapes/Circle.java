package shapes;

public class Circle implements Shape{

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double calculateArea() {
        return Math.PI * (double)(this.radius * this.radius);
    }

}
