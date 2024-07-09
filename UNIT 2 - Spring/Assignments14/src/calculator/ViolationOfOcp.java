package calculator;

import shapes.Circle;
import shapes.Rectangle;

/*
The calculateArea method in ViolationOfOcp contains a series of if/else if statements
to determine the type of shape and then calculate its area accordingly.
If we want to add a new shape type (e.g., Triangle), we would need to:
Modify the calculateArea method by adding a new else if block for the Triangle type.

This direct modification of existing code goes against the "closed for modification" part of OCP
 */

public class ViolationOfOcp {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getLength();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        }
        return 0.0;
    }
}
