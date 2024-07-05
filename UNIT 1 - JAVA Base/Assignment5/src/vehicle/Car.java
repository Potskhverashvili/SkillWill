package vehicle;

public class Car extends Vehicle {
    @Override
    public void brand(String brand) {
        System.out.println("Brand: " + brand);
    }

    @Override
    public void speed(int speed) {
        System.out.println("Speed: " + speed);
    }

    @Override
    public void color(String color) {
        System.out.println("Color: " + color);
    }
}
