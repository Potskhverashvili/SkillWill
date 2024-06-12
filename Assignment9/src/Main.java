import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ----------------------------- Task1: Print String number as a Integer -----------------------------------
        System.out.println("------------ First Task -------------");
        List<String> strNums = new ArrayList<>(List.of("33", "59", "78"));
        printStringToInteger(strNums);

        // ------------------------ Task2: Create a Car objects and display its information ----------------------------
        System.out.println("\n---------- Second Task -------------");
        Car car1 = new Car("BMW", "M3", 2022, 4);
        Car car2 = new Car("Mercedes", "C180", 2022, 4);
        Car car3 = new Car("Mazda", "RX3", 2020, 4);

        // Print objects
        printCarDetails(car1);
        printCarDetails(car2);
        printCarDetails(car3);

        // Update and print car1
        car1.updateCarInfo("Ford", "Mustang", 2021);
        printCarDetails(car1);
    }

    // ------------------------------------------ FUNCTIONS -----------------------------------------

    // Helper function print objects
    static void printCarDetails(Car car)   {
        System.out.println(car);
        System.out.println("-------");
    }

    // Helper function print result of convert.
    static void printStringToInteger(List<String> strNums) {
        for (String num : strNums) {
            System.out.println("\"" + num + "\"" + " : Print as a Integer : " + stringToInteger(num));
        }
    }

    // function to convert a String to an Integer
    static Integer stringToInteger(String strNum) {
        return Integer.parseInt(strNum);
    }
}