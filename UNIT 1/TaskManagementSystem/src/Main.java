import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------- Task Management System --------------------");
        startApp();
    }

    // save tasks
    static Map<String, Task> tasksMap = new HashMap<>();

    static void startApp() {
        String userName = inputString("- Enter user name - : ");
        System.out.println(" - User - : " + userName);
        while (true) {

            System.out.println("""
                    \n- Choose Operation - :\s
                    1. Create Task
                    2. View All Task
                    3. Update Task
                    4. Delete Task
                    5. View Task Details
                    0. Exit""");

            int operation = inputNumber("- Enter Operation Number - : ");
            switch (operation) {
                case 1 -> createTask(userName);
                case 2 -> viewAllTask();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> viewTaskDetails();
                case 0 -> {
                    System.out.println("Exiting Task Management System...");
                    return;
                }
                default -> System.out.println(" - Invalid operation. Please try again. - ");
            }
        }
    }

    // ---------------------------------------------------------- Helper Functions ----------------------------------------
    static void createTask(String userName) {
        int taskType;
        while (true) {
            System.out.println("""
                    \n- Choose Task Type - :\s
                    1. LimitedTimeTask
                    2. Repeatable Task
                    3. BasicTask
                    0. <- Back
                    """);

            taskType = inputNumber("- Enter Task Type Number - : ");
            switch (taskType) {
                case 1 -> createLimitedTimeTask(userName);
                case 2 -> createRepeatableTask(userName);
                case 3 -> createBasicTask(userName);
                case 0 -> {
                    System.out.println("- Return Back -");
                    return;
                }
                default -> System.out.println(" - Input correct operation - ");
            }
        }
    }

    // View All Task
    static void viewAllTask() {
        System.out.println(" --- Print all Task ----");
        if (!tasksMap.isEmpty()) {
            for (String key : tasksMap.keySet()) {
                System.out.println(key);
            }
        } else {
            System.out.println(" - No Task Found - ");
        }
    }

    // Update Concrete Task
    static void updateTask() {
        String taskName = inputString("- Input Task Name: ");
        if (tasksMap.containsKey(taskName)) {

            Task taskToUpdate = tasksMap.get(taskName);
            // 1. Show Existing Task Details
            System.out.println("Current Task Details:");
            System.out.println(taskToUpdate);

            // 2. Get Updated Details from User
            System.out.println("Enter new details (leave blank to keep current value):");
            String newDescription = inputString("- New Description: ");

            if (taskToUpdate instanceof BasicTask) {
                // BasicTask only has description to Update
                if (!newDescription.isEmpty()) {
                    taskToUpdate.setDescription(newDescription);
                }
            } else if (taskToUpdate instanceof RepeatableTask) {
                // RepeatableTask has description, repeat, and data
                String newRepeat = inputString("- New Repeat: ");
                String newData = inputString("- New Data: ");

                if (!newDescription.isEmpty()) {
                    taskToUpdate.setDescription(newDescription);
                }
                if (!newRepeat.isEmpty()) {
                    ((RepeatableTask) taskToUpdate).setRepeat(newRepeat);
                }
                if (!newData.isEmpty()) {
                    ((RepeatableTask) taskToUpdate).setData(newData);
                }
            } else if (taskToUpdate instanceof LimitedTimeTask) {
                // LimitedTimeTask has description and deadline
                String newDeadline = inputString("- New Deadline: ");

                if (!newDescription.isEmpty()) {
                    taskToUpdate.setDescription(newDescription);
                }
                if (!newDeadline.isEmpty()) {
                    // Validate newDeadline (e.g., using DateTimeFormatter)
                    ((LimitedTimeTask) taskToUpdate).setDeadline(newDeadline);
                }
            }

            System.out.println("Task updated successfully!");

        } else {
            System.out.println(taskName + " < - This Task Doesn't Exist - ");
        }
    }

    // Delete Concrete Task
    static void deleteTask() {
        String taskName = inputString("- Input Task Name: ");
        if (tasksMap.containsKey(taskName)) {
            tasksMap.remove(taskName);
            System.out.println("Task: " + taskName + " - Deleted");
        } else {
            System.out.println(taskName + " < - This Task Doesn't Exist");
        }
    }

    // View Concrete Task
    static void viewTaskDetails() {
        String taskName = inputString("- Input Task Name: ");
        if (tasksMap.containsKey(taskName)) {
            System.out.println(tasksMap.get(taskName));
        } else {
            System.out.println(taskName + " < - This Task Doesn't Exist");
        }
    }

    // --------------------------------------- Create Different Type Tasks ----------------------------------

    // Create LimitedTimeTask Function
    static void createLimitedTimeTask(String userName) {

        // TODO LocalDataTime
        System.out.println(" - Limited Time Task - ");
        String taskName = inputString("- Enter Task Name - : ");
        String description = inputString("- Enter Description - : ");
        String deadLine = inputString("- Enter Dead line date - : ");

        Task task = new LimitedTimeTask(userName, taskName, description, deadLine);

        if (tasksMap.containsKey(task.taskName)) {
            System.out.println(" - Task name already exists. Add not successful.");
        } else {
            tasksMap.put(task.taskName, task);
            System.out.println(" - Add successful! - ");
        }
    }

    // Create RepeatableTask Function
    static void createRepeatableTask(String userName) {
        System.out.println(" - Repeatable Task - ");
        String taskName = inputString("- Enter Task Name - : ");
        String description = inputString("- Enter Description - : ");
        String repeat = inputString("- Repeat - : ");
        String data = inputString("- Date & Time - : ");

        RepeatableTask task = new RepeatableTask(userName, taskName, description, repeat, data);

        if (tasksMap.containsKey(task.taskName)) {
            System.out.println(" - Task name already exists. Add not successful. - ");
        } else {
            tasksMap.put(task.taskName, task);
            System.out.println("- Add successful! - ");
        }
    }

    // Create Basic Task
    static void createBasicTask(String userName) {
        System.out.println(" - create Basic Task - ");
        String taskName = inputString("- Enter Task Name - : ");
        String description = inputString("- Enter Description - : ");

        BasicTask task = new BasicTask(userName, taskName, description);

        if (tasksMap.containsKey(task.taskName)) {
            System.out.println(" - Task name already exists. Add not successful. - ");
        } else {
            tasksMap.put(task.taskName, task);
            System.out.println(" - Add successful! - ");
        }
    }

    // ----------------------------------------------- Input Helper Functions ----------------------------------------
    static int inputNumber(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextInt();
    }

    static String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextLine();
    }
}