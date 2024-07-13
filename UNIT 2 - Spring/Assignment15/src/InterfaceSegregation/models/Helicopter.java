package InterfaceSegregation.models;
import InterfaceSegregation.Flyable;
import InterfaceSegregation.Vehicle;

public class Helicopter implements Vehicle, Flyable {

    @Override
    public void fly() {
        Flyable.super.fly();
    }

    @Override
    public void startEngine() {
        Vehicle.super.startEngine();
    }

    @Override
    public void stopEngine() {
        Vehicle.super.stopEngine();
    }
}
