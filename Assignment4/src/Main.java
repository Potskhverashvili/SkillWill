public class Main {
    public static void main(String[] args) {

        // First object
        Car car1 = new Car();
        car1.setModel("BMW M3");
        car1.setEngineType("Petrol");
        car1.setGearBoxType("Manual");
        car1.setBodyStyle("Coupe");
        car1.setColor("SkyBlue");


        // Second Object
        Car car2 = new Car("Mercedes E320", "Petrol", "Automatic", "Sedan", "Black");

        System.out.println(car2.getModel());
        System.out.println(car2.getEngineType());
        System.out.println(car2.getGearBoxType());
        System.out.println(car2.getBodyStyle());
        System.out.println(car2.getColor());

    }
}