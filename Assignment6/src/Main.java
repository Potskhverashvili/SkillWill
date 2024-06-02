public class Main {
    public static void main(String[] args) {

        // Task 1: Print all elements in a string array
        System.out.println("------------- First Task ---------------------");
        String[] words = {"hello", "world", "sun", "moon", "car", "tree", "book", "cat", "dog", "flower"};
        printStringArray(words);

        // Task 2: Find the index of a specific target value in an integer array
        System.out.println("\n------------ Second Task ---------------------");
        int[] numbers = {1, 2, 3, 4};
        findTargetIndex(numbers, 2); // Search for the number 2 (exists)
        findTargetIndex(numbers, 7); // Search for the number 7 (doesn't exist)
    }

    //-------------------------------- Helper Functions ----------------------------
    /**
     * Prints each element of a string array along with its index.
     *
     * @param words The array of strings to print
     */
    static void printStringArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.println("index[" + i + "] - " + words[i] + ", "); // Print the index and the corresponding word
        }
    }

    /**
     * Searches for a specific target value within an integer array.
     * Prints the index of the first occurrence of the target value if found.
     *
     * @param numbers The array of integers to search.
     * @param  target  The value to search for.
     */
    static void findTargetIndex(int[] numbers, int target) {
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Entered Number's Index is: " + i);
                found = true;
                break; //  Exit the loop after finding the number
            }
        }
        // If the loop finishes and found is still true, the number wasn't found
        if (!found) {
            System.out.println("not found");
        }
    }
}