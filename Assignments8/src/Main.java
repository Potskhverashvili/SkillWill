import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("------------- Task1 : Find common elements in two sets --------------");
        // Create set1
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(6);
        set1.add(3);
        set1.add(4);

        // Create set2
        Set<Integer> set2 = new HashSet<>();
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(4);

        // Print the original sets
        System.out.println("First set: " + set1);
        System.out.println("Second set: " + set2);

        // Find and print common elements
        System.out.println("Same Elements: " + sameElements(set1, set2));


        // --------------------------------------- Second Task ----------------------------------------
        System.out.println("------------- Task2 ----------------");

        Car car1 = new Car("Honda", "Black");
        Car car2 = new Car("Toyota", "Withe");
        Car car3 = new Car("BMW", "blue");
        Car car4 = new Car("Mercedes", "Red");
        Car car5 = new Car("Mazda", "Yellow");
        Car car6 = new Car("Ford", "Withe");

        List<Car> carList1 = new ArrayList<>(List.of(car1, car2, car3, car4));
        List<Car> carList2 = new ArrayList<>(List.of(car1, car3, car6));
        List<Car> carList3 = new ArrayList<>(List.of(car1, car2, car3, car4));

        Map<Integer, List<Car>> carsMap = new HashMap<>();
        carsMap.put(2019, carList1);
        carsMap.put(2020, carList2);
        carsMap.put(2021, carList3);

        prodYears(carsMap);

    }

    // --------------------------------------------- FUNCTIONS -------------------------------------------------

    // Find common elements in two sets
    static Set<Integer> sameElements(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        for (Integer element : set1) {
            // if (set2.contains(element)) - Alternative way
            if (!set2.add(element)) { //If adding to set2 is false (element exists - it's same)
                result.add(element);
            }
        }
        return result;
    }


    // --------------------------------------- Second Task ----------------------------------------
    static void prodYears(Map<Integer, List<Car>> cars) {

        int year = 0;
        int compare = 0;
        Set<Integer> keys = cars.keySet();

        for (Integer key : keys){
            if (compare < cars.get(key).size()){
                year = key;
                compare = cars.get(key).size();
            }
        }
        System.out.println("Years: " + year);
    }
}

