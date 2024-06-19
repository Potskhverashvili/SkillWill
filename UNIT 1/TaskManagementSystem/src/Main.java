import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------- Task Management System --------------------");
        startApp();

    }
    static void startApp() {
         String userName = inputString("- Enter user name - : ");
        System.out.println("""
                \n- Choose Operation - :\s
                1. Create Task
                2. Get All Task
                3. Update Task
                4. Delete Task
                5. Get Task""");

        int operation = inputNumber("- Enter Operation Number - : ");
        switch (operation) {
            case 1 -> saveTask(userName);
            case 2 -> getTasks();
            case 3 -> updateTask();
            case 4 -> deleteTask();
            case 5 -> getTask();
        }
    }

    // ---------------------------------------------------------- Helper Functions ----------------------------------------
    static void saveTask(String userName) {
        int taskType = 0;
        System.out.println("""
                \n- Choose Task Type - :\s
                1. LimitedTimeTask
                2. Repeatable Task
                3. BasicTask""");

        taskType = inputNumber("- Enter Task Type Number - : ");


        switch (taskType) {
            case 1 -> createLimitedTimeTask(userName);
        }

    }

    static void getTasks() {
        System.out.println("Get All Tasks");
    }

    static void updateTask() {
        System.out.println("Update Task");
    }

    static void deleteTask() {
        System.out.println("Delete Task");
    }

    static void getTask() {
        System.out.println("get Task");
    }

    // ------------ Create Different Type Functions --------
   static void createLimitedTimeTask(String userName){
        LimitedTimeTask task = new LimitedTimeTask();
        task.userName = userName;
        task.taskName = inputString("- Enter Task Name - : ");
        task.description = inputString("- Enter Description - : ");
        task.deadLine = inputString("- Enter Dead line date - : ");
    }

    // -------------- Input Helper Functions ---------------

    static int inputNumber(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextInt();
    }

    static String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.next();
    }

}