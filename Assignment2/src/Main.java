public class Main {
    public static void main(String[] args) {

        System.out.println("-------------- Firs Task -------------");
        printAnimalType("Dog");
        printAnimalType("cat");
        printAnimalType("LION");
        printAnimalType("pig");
        printAnimalType("Panda");

        System.out.println("\n-------------- Second Task ------------");
        printPower(2, 0);
        printPower(2, 1);
        printPower(2, 2);
        printPower(2, 3);
        printPower(2,4);
        System.out.println();
        printPower(3, 0);
        printPower(3, 1);
        printPower(3, 2);
        printPower(3, 3);
    }

    // ------------------------ First Task --------------------------

    static void printAnimalType(String animal) {
        // Convert the input to uppercase for case-insensitive comparison
        String upperCaseAnimal = animal.toUpperCase();
        switch (upperCaseAnimal) {
            case "DOG":
                System.out.println("I am the Dog");
                break;
            case "CAT":
                System.out.println("I am the Cat");
                break;
            case "LION":
                System.out.println("I am the Lion");
                break;
            case "PIG":
                System.out.println("I am the Pig");
                break;
            default:
                System.out.println("I am an Animal");
        }
    }

    // --------------------- Second Task ----------------------

    static void printPower(int base, int exponent) {
        System.out.println(base + "^" + exponent + "= " + powerWithWhile(base, exponent));
    }

    static int powerWithWhile(int base, int exponent) {
        // base^0 = 1
        if (exponent == 0) return 1;
        int result = 1;
        while (exponent != 0) {
            result *= base;
            exponent--;
        }
        return result;
    }

    static int powerWithFor(int base, int exponent) {
        // base^0 = 1
        if (exponent == 0) return 1;
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}