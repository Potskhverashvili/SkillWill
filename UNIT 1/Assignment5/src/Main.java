import Messenger.Card;
import vehicle.Car;
import vehicle.Truck;

public class Main {
    public static void main(String[] args) {

        // Task 1: Demonstrate Greeting Card Functionality
        System.out.println("----------- Greeting Card Demo ----------");
        Card greetingCard = new Card();// Create a new greeting card object

        // Send single message
        greetingCard.hello("Hello");

        // Send repeated message
        greetingCard.hello("Congregations! ", 3);

        // Task 2: Demonstrate Vehicle Functionality
        System.out.println("\n---------- Vehicle Demo ----------");

        // Create and configure Car objects
        Car mercedes = new Car();
        setCarDetails(mercedes, "Mercedes GTS", 300, "Black");// Set details and display info
        Car bmw = new Car();
        setCarDetails(bmw, "BMW M3", 280, "Gray");

        // Create and configure Truck objects
        Truck volvo = new Truck();
        setTruckDetails(volvo, "VOLVO TGM", 120, "White");
        Truck daf = new Truck();
        setTruckDetails(daf, "DAF TGS", 110, "Black");

    }

    // Helper method to set details for a Car and display its information
    static void setCarDetails(Car car, String brand, int speed, String color) {
        car.brand(brand);
        car.speed(speed);
        car.color(color);
        car.amountOfWheels();
        System.out.println();
    }

    // Helper method to set details for a Truck and display its information
    static void setTruckDetails(Truck truck, String brand, int speed, String color) {
        truck.brand(brand);
        truck.speed(speed);
        truck.color(color);
        truck.amountOfWheels();
        System.out.println();
    }
}