public class Car extends Vehicle {

    int wheelCount;

    Car(String brand, String modelName, int releaseYear, int wheelCount) {
        super(brand, modelName, releaseYear);
        this.wheelCount = wheelCount;
    }

    @Override
    public String toString() {
        return "Brand: "+ getBrand() + "\nModel: " + getModelName() + "\nRelease Year: " + getReleaseYear() + "\nWheels: " + wheelCount;
    }
}
