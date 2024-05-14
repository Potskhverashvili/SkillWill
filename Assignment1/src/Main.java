public class Main {
    public static void main(String[] args) {
        // Initialize integer values
        int num1 = 4;
        int num2 = 3;
        int num3 = 7;
        int num4 = 9;

        // Initialize string values
        String str1 = "Hello";
        String str2 = "Java";
        String str3 = "World";

        // Print average of the numbers
        System.out.println("Average is: " + findAverage(num1, num2, num3, num4));

        // Print sum of lengths of the strings
        System.out.println("Sum of Strings length is : " + sumStringLengths(str1, str2, str3));
    }

    // Calculate average of four numbers
    static int findAverage(int num1, int num2, int num3, int num4) {
        return (num1 + num2 + num3 + num4) / 4;
    }

    // Calculate sum of lengths of three strings
    static int sumStringLengths(String str1, String str2, String str3) {
        return str1.length() + str2.length() + str3.length();
    }
}