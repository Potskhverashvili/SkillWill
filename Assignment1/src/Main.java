public class Main {
    public static void main(String[] args) {
        // Initialize integer values
        int num1 = 4;
        int num2 = 3;
        int num3 = 7;
        int num4 = 9;

        // Initialize string values
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "of Java";

        // Print average of the numbers
        System.out.println("Four number average is: " + findAverage(num1, num2, num3, num4));

        // Print sum of lengths of the strings
        System.out.print("Sum of Strings length is : " + sumStringLengths(str1, str2, str3));

        // Print amount of character and space
        countCharAndSpace(str1, str2, str3);
    }

    // Calculate average of four numbers
    static int findAverage(int num1, int num2, int num3, int num4) {
        return (num1 + num2 + num3 + num4) / 4;
    }

    // Calculate sum of lengths of three strings
    static int sumStringLengths(String str1, String str2, String str3) {
        return str1.length() + str2.length() + str3.length();
    }

    // Space Counter
    static void countCharAndSpace(String str1, String str2, String str3) {
        int spaceCount = 0;
        int charCount;
        String sentence = str1 + str2 + str3;
        char[] charArray = sentence.toCharArray();

        for (char c : charArray) {
            if (c == ' ')
                spaceCount++;
        }
        charCount = (sentence.length() - spaceCount);
        System.out.println(" --> " + charCount + " of them are Character and " + spaceCount + " is Space");
    }
}