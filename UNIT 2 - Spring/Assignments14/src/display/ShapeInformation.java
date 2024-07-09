package display;

import shapes.Shape;
public class ShapeInformation {
    public  String getShapeType(Shape shape) {
        return shape.getClass().getSimpleName();
    }
}
