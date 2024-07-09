package calculator;

import shapes.Shape;
/*
The ViolationOfSrp class is violating the Single Responsibility Principle (SRP)
because it has more than one reason to change:
  1. calculateArea
  2. getShapeType
 */

public class ViolationOfSrp {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }

    public String getShapeType(Shape shape) {
        return shape.getClass().getSimpleName();
    }
}
