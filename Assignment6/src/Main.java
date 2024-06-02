public class Main {
    public static void main(String[] args) {

        System.out.println("------------- First Task ---------------------");
        String[] words = {"hello", "world", "sun", "moon", "car", "tree", "book", "cat", "dog", "flower"};
        printStringArray(words);

        System.out.println("\n------------ Second Task ---------------------");
        int[] numbers = {1, 2, 3, 4};
        findTargetIndex(numbers, 2);
        findTargetIndex(numbers, 7);
    }

    //-------------------------------- Helper Functions ----------------------------
    // String Array Printing
    static void printStringArray(String[] words) {
        for (int i = 0; i < words.length ; i++) {
            System.out.println("index[" + i + "] - " + words[i] + ", ");
        }
    }

    // Find Target Index
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