import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ----------------------------- First Task -----------------------------------
      /*  System.out.print("Enter Number as a String: ");
        System.out.println("Print as a Integer: " + stringToInteger(input.next()));*/

        // ------------------------------ Second Task ----------------------------------

        Vehicle car = new Car("BMW", "M3", 2022, 4);
        System.out.println(car);

    }

    static Integer stringToInteger(String strNum) {
        return Integer.parseInt(strNum);
    }
}