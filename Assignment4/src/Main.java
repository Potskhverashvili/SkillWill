import Car.Car;

public class Main {
    public static void main(String[] args) {
        // Create the first Car object
        Car car1 = new Car();
        car1.setBrand("BMW");
        car1.setModel("M3");
        car1.setEngineType("Petrol");
        car1.setGearBoxType("Manual");
        car1.setColor("White");

        // Create the second Car object
        Car car2 = new Car("Mercedes", "E320", "Petrol", "Automatic", "Black");

        // Print car details using car objects
        printCarDetails(car1);
        printCarDetails(car2);


    }

    // ------------------------------------- Helper Functions -----------------------------

    // function to print car details using a Car object
    public static void printCarDetails(Car car) {
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Engine Type: " + car.getEngineType());
        System.out.println("Gearbox Type: " + car.getGearBoxType());
        System.out.println("Color: " + car.getColor());
        System.out.println("--------");
    }
}