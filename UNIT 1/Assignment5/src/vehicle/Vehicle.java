package vehicle;

public abstract class Vehicle {
    // Abstract methods
    abstract void brand(String brand);
    abstract void speed(int speed);
    abstract void color(String color);

    // Concrete method
     public void amountOfWheels() {
        System.out.println("Amount of Wheel: 4");
    }
}
