public class Car extends Vehicle {

    // Additional property specific to cars
    int wheelCount;

    // Constructor to initialize a Car object
    Car(String brand, String modelName, int releaseYear, int wheelCount) {
        super(brand, modelName, releaseYear);
        this.wheelCount = wheelCount;
    }

    // Updates the car's information.
    public void updateCarInfo(String brand, String modelName, Integer releaseYear){
        super.setBrand(brand);
        super.setModelName(modelName);
        super.setReleaseYear(releaseYear);
    }

    // Overrides the toString() method
    @Override
    public String toString() {
        return "Brand: " + getBrand() +
                "\nModel: " + getModelName() +
                "\nRelease Year: " + getReleaseYear() +
                "\nWheels: " + wheelCount;
    }
}
