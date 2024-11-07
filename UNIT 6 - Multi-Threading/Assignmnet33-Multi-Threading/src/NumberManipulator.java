import java.util.Scanner;

public class NumberManipulator {

    private static int number;

    public static void main(String[] args) throws InterruptedException {
        number = inputNumber();

        Thread multiplyThread = new Thread(() -> multiplyByTwo());
        Thread plusThread = new Thread(() -> additionToTen());

        multiplyThread.start();
        multiplyThread.join();

        plusThread.start();
        plusThread.join();

        System.out.println("Final Result: " + number);
    }

    // --------------------- Helper Methods -----------------------
    private static void multiplyByTwo() {
        number *= 2;
        System.out.println("Result By: " + Thread.currentThread().getName() + " = " + number);
    }

    private static void additionToTen() {
        number += 10;
        System.out.println("Result by: " + Thread.currentThread().getName() + " = " + number);
    }

    private static int inputNumber() {
        System.out.print("Enter Number: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}