public class Main {
    public static void main(String[] args) {
        // ----------------------------- Task1: Print String number as a Integer -----------------------------------
        System.out.println("------------ First Task -------------");

        // Test cases: Valid and invalid integer strings
        printStringToInteger("0");
        printStringToInteger("2");
        printStringToInteger("99");
        printStringToInteger("44");
        printStringToInteger(" "); // invalid (space)
        printStringToInteger("f"); // Invalid (letter)
        printStringToInteger("33f"); // Invalid (letter and number)

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

    // ------------------------------------------ Task:1 Helper Functions -----------------------------------------
    // Prints a string as an integer or indicates invalid input
    static void printStringToInteger(String strNums) {
        if (isValidInteger(strNums)) { // return true if the string is a valid integer,
            System.out.println("\"" + strNums + "\"" + " : Print as a Integer : " + convertStringToInteger(strNums));
        } else {
            System.out.println("\"" + strNums + "\"" + " : String Must contain only numbers");
        }
    }

    /*
    ASCII values for digits are sequential: '0' = 48, '1' = 49, ..., '9' = 57.
    Converts a character representing a digit ('0' to '9') to its integer equivalent,
    by subtracting the ASCII value of '0' (48).
    Example: '5' (ASCII 53) - '0' (ASCII 48) = 5 (the integer value)
     */

    static Integer convertStringToInteger(String strNum) {
        int result = 0;
        char[] charArr = strNum.toCharArray();

        // Process each character, building the integer value
        for (char element : charArr) {
            result *= 10; // Shift existing digits to the left
            result = result + (element - '0'); // Add the value of the current digit
        }
        return result;
    }
     /*  -------- Alternative function: ----------
    static Integer convertStringToInteger(String strNum) {
    return Integer.parseInt(strNum);
    }
    */

    // Checker function - return true if the string is a valid integer, false otherwise.
    static boolean isValidInteger(String strNum) {
        char[] charArr = strNum.toCharArray();
        for (char element : charArr) {
            // Check if the character is not a digit (0-9)
            if (!(element >= '0' && element <= '9'))
                return false;
        }
        return true;
    }

    // ------------------------------------------ Task:2 Functions -----------------------------------------
    // Helper function print objects
    static void printCarDetails(Car car) {
        System.out.println(car);
        System.out.println("-------");
    }
}