package InterfaceSegregation;

public interface Vehicle {
   default void startEngine(){}
   default void stopEngine(){}
}
