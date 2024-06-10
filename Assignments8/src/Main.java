import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ------------------------------------------- Task 1 ------------------------------------------
        System.out.println("------------- Task1 : Find common elements in two sets --------------");

        // Create two sets of numbers to find common elements in
        Set<Integer> numbersSet1 = new HashSet<>(Arrays.asList(5, 6, 3, 4));
        Set<Integer> numbersSet2 = new HashSet<>(Arrays.asList(5, 6, 7, 4));

        // Print the original sets
        System.out.println("First set: " + numbersSet1);
        System.out.println("Second set: " + numbersSet2);

        // Call a function to find and print the common elements
        System.out.println("Same Elements: " + commonElements(numbersSet1, numbersSet2));


        // --------------------------------------------- Task 2 --------------------------------------------------
        System.out.println("\n------------- Task 2: Max Car Production Year --------------");

        // Create car objects
        Car car1 = new Car("Honda", "Black");
        Car car2 = new Car("Toyota", "White");
        Car car3 = new Car("BMW", "blue");
        Car car4 = new Car("Mercedes", "Red");
        Car car5 = new Car("Mazda", "Yellow");
        Car car6 = new Car("Ford", "White");

        // Create lists of cars
        List<Car> carList1 = new ArrayList<>(List.of(car1, car2, car3, car4));
        List<Car> carList2 = new ArrayList<>(List.of(car1, car3, car6));
        List<Car> carList3 = new ArrayList<>(List.of(car1, car2, car3, car4, car5));

        // Create a map to associate years with their car production lists
        Map<Integer, List<Car>> carsByYear = new HashMap<>();
        carsByYear.put(2019, carList1);
        carsByYear.put(2020, carList2);
        carsByYear.put(2021, carList3);

        // Call a function to determine and print the year with the most cars produced
        System.out.println("The most cars produced in: " + findYearWithMaxCars(carsByYear));
    }

    // --------------------------------------------- FUNCTIONS -------------------------------------------------
    // -------- Function to find common elements in two sets ----------
    static Set<Integer> commonElements(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> commonElements = new HashSet<>();
        for (Integer element : set1) {
            //if (set2.contains(element)) // Alternative way
            if (!set2.add(element)) { // If add to set2 fails (already exists)
                commonElements.add(element);
            }
        }
        return commonElements;
    }

    // --- Function to find the year with the highest car production in a map ---
    static int findYearWithMaxCars(Map<Integer, List<Car>> carsByYear) {
        int carsYear = 0;
        int maxCar = 0;

        // Iterate through each year (key) and its corresponding list of cars (value)
        for (Map.Entry<Integer, List<Car>> entry : carsByYear.entrySet()) {

            // If the current year has more cars than the previous, update
            if (maxCar < entry.getValue().size()) {
                maxCar = entry.getValue().size();
                carsYear = entry.getKey();
            }
        }
        return carsYear;
    }

    // ------------------------ Second Version ---------------------
    /*static int findYearWithMaxCars(Map<Integer, List<Car>> carsByYear) {
        int carsYear = 0;
        int maxCar = 0;
        Set<Integer> keys = carsByYear.keySet();

        for (Integer key : keys) {
            if (maxCar < carsByYear.get(key).size()) {
                maxCar = carsByYear.get(key).size();
                carsYear = key;
            }
        }
        return carsYear;
    }
*/
}

