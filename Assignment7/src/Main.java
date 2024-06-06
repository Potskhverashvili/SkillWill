import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------- Task 1: Word List ------------------------");
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("code");
        words.add("list");
        words.add("example");
        words.add("ten");
        words.add("words");
        words.add("filled");
        words.add("array");

        for (String word : words) {
            System.out.print(word + ", ");
        }

        System.out.println("\n\n---------------------- Task 2: Max Value  -----------------------");
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        // Fill lists with random integers
        fillIntegerList(listA, 3);
        fillIntegerList(listB, 4);

        // Print the contents of both lists
        System.out.print("First List: ");
        printIntegerList(listA);
        System.out.print("Second List: ");
        printIntegerList(listB);

        // Find and print max value.
        System.out.println("Max Value: " + findMaxBetweenLists(listA, listB));

    }

    // --------------- FUNCTION: Finds and returns the maximum value between two integer lists. -----------------
    static int findMaxBetweenLists(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        /*
        Alternative implementation using Collections.max()
        int max1 = Collections.max(listA);
        int max2 = Collections.max(listB);
        */
        int max1 = findMaxValue(listA);
        int max2 = findMaxValue(listB);

        /*
        Alternative way to find the max value between two integers
        return Math.max(max1, max2);
        */
        return (max1 > max2) ? max1 : max2;
    }

    // ------------------------------------------ HELPER FUNCTIONS ---------------------------------------------
    // Finds the maximum value within a single integer list.
    static int findMaxValue(ArrayList<Integer> list) {
        int maxvalue = list.get(0);
        for (Integer integer : list) {
            if (maxvalue < integer)
                maxvalue = integer;
        }
        return maxvalue;
    }

    // Fills a list with random integers up to a specified size.
    static void fillIntegerList(ArrayList<Integer> list, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100)); // Add a random number between 0 and 99
        }
    }

    // Prints the elements of an integer list.
    static void printIntegerList(ArrayList<Integer> list) {
        for (Integer nums : list) {
            System.out.print(nums + ", ");
        }
        System.out.println();
    }
}