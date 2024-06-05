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

        // // Print lists.
        System.out.print("First List: ");
        printIntegerList(listA);
        System.out.print("Second List: ");
        printIntegerList(listB);

        // Find and print max value.
        System.out.println("Max Value: " + findMaxBetweenLists(listA, listB));

    }

    // --------------------------------------- Functions -----------------------------------------------
    // Finds and returns the maximum value between two integer lists.
    static int findMaxBetweenLists(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        //int max1 = Collections.max(listA);
        int max1 = findMaxValue(listA);
        int max2 = findMaxValue(listB);

        return Math.max(max1, max2);
    }

    // --------------------- Helpers ------------------------
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
        for (int i = 0; i < size ; i++) {
            list.add(random.nextInt(100));
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