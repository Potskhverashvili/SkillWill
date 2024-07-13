package LiskovSubstitution.models;

import LiskovSubstitution.Shape;

public class Rectangle implements Shape {

    double width;
    double length;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return width * length;
    }
}
