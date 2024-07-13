package InterfaceSegregation.models;

import InterfaceSegregation.Driveable;
import InterfaceSegregation.Vehicle;

// Suppose that PDF couldn't text edit, Accordingly it doesn't need TextEditor Interface
// If we had TextEditor and SendViaEmail in one interface it would be a violation of Interface Segregation

public class Car implements Vehicle, Driveable {

    @Override
    public void drive() {
        Driveable.super.drive();
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
