import java.util.Scanner;

public class Tests {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number: ");
        int num  = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter String: ");
        String str = scanner.nextLine();

        System.out.println(num);
        System.out.println(str);

        

    }
}
