public class CompetitiveIncrement {

    private static int number;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> incrementMethod());
        Thread thread2 = new Thread(() -> incrementMethod());

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println("Final Result: " + number);
    }

    // -------------------- Increment Method ----------------------
    private static void incrementMethod() {
        for (int i = 0; i < 10000; i++) {
            number++;
        }
        System.out.println("Result by: " + Thread.currentThread().getName() + " = " + number);
    }
}
