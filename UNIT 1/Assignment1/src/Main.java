public class Main {
    public static void main(String[] args) {
        // Initialize an array of integers
        int[] nums = {3, 3, 2, 3};

        // Initialize an array of strings
        String[] str = {"Hello", "World", "of Java"};

        System.out.println("-------- First Task ---------");
        printAverage(nums);

        System.out.println("\n------- Second Task ---------");
        printStringLengthSum(str);
    }

    // --------------------------------- First Task Solution -----------------------------
    static void printAverage(int[] nums) {
        System.out.println("Entered " + nums.length +
                " numbers average is: " + findAverage(nums));
    }

    static Double findAverage(int[] nums) {
        int sumOfnums = 0;
        double result;
        for (int elements : nums) {
            sumOfnums += elements;
        }

        result = (double) sumOfnums / nums.length;
        return result;
    }

    // -------------------------------- Second Task Solutions -----------------------------
    static void printStringLengthSum(String[] str) {
        System.out.print("Entered String sum is: " + sumStringLengths(str));
        countCharAndSpace(str);
    }

    // Calculate sum of lengths of strings
    static int sumStringLengths(String[] str) {
        int len = 0;
        for (String element : str) {
            len += element.length();
        }
        return len;
    }

    // Space Counter
    static void countCharAndSpace(String[] str) {
        String concat = ""; // Initialize an empty string to concatenate elements
        int spaceCount = 0;
        int charCount;

        // Concatenate all elements
        for (String elements : str) {
            concat += elements;
        }

        // Convert the concat to a character array
        char[] arr = concat.toCharArray();

        // Count the number of spaces in the concatenated string
        for (char element : arr) {
            if (element == ' ')
                spaceCount++;
        }

        charCount = (concat.length() - spaceCount);
        System.out.println(" - (" + charCount + " of them are Character and " + spaceCount + " is Space)");
    }
}