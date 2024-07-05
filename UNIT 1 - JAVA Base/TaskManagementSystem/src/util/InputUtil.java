package util;

import java.util.Scanner;

public class InputUtil {

    public int inputNumber(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextInt();
    }

    public String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextLine();
    }
}
