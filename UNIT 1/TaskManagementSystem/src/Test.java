import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Map<String, Task> taskMap = new HashMap<>();
        String userName = inputString("Enter User Name: ");
        String taskName = inputString("Enter Task Name: ");
        String description = inputString("Enter Description: ");
        String repeat = inputString("Repeat: ");
        String data = inputString("Data");

        BasicTask task1 = new BasicTask(userName, taskName, description);

        RepeatableTask task2 = new RepeatableTask(userName, taskName, description, repeat, data);

        taskMap.put(task1.taskName, task1);
        taskMap.put(task2.taskName, task2);

        System.out.println(task1);
        System.out.println(task2);

        if (taskMap.containsKey(inputString("- Input Task Name: "))) {
            Task taskToUpdate = taskMap.get(taskName);

            // 1. Show Existing Task Details
            System.out.println("Current Task Details:");
            System.out.println(taskToUpdate);

            // 2. Get Updated Details from User
            System.out.println("Enter new details (leave blank to keep current value):");
            String newDescription = inputString("- New Description: ");

            taskToUpdate.setDescription(newDescription);

            taskMap.get(taskName).setDescription(newDescription);



        } else {
            System.out.println(taskName + " < - This Task Doesn't Exist - ");
        }

    }

    static String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextLine();
    }
}
