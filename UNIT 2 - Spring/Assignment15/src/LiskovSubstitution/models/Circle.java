package LiskovSubstitution.models;

import LiskovSubstitution.Shape;

public class Circle implements Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (radius * 2);
    }
}
