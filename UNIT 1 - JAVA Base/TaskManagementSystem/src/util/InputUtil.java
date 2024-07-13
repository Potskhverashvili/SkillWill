package util;

import java.util.Scanner;

public class InputUtil {

   static public int inputNumber(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextInt();
    }

   static public String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextLine();
    }
}
