package ui;

import model.BasicTask;
import model.LimitedTimeTask;
import model.RepeatableTask;
import model.Task;
import storage.TaskStorage;

public class UserInterface {

    public void startApp() {
        String userName = inputString("- Enter user name - : ");
        System.out.println("- User : " + userName);

        while (true) {
            printMainMenu();
            switch (inputNumber("- Enter Operation Number - : ")) {
                case 1 -> createTask(userName);
                case 2 -> viewAllTask();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> viewTaskDetails();
                case 0 -> {
                    System.out.println("Exiting tasks.Task Management System...");
                    return;
                }
                default -> System.out.println(" - Invalid operation. Please try again. - ");
            }
        }
    }

    // ---------------------------------------------------------- Functions ------------------------------------------
    static void createTask(String userName) {
        Task task;
        while (true) {
            printTaskTypeMenu();
            int taskType = inputNumber("- Enter tasks.Task Type Number - : ");
            if (taskType == 0) {
                return;
            }
            String taskName = inputString("- Enter tasks.Task Name - ");
            String description = inputString("- Enter Description - ");

            switch (taskType) {
                case 1 -> {
                    task = new LimitedTimeTask(userName, taskName, description, inputString("- Enter Deadline: "));
                    new TaskStorage(taskName, task);
                    System.out.println("tasks.Task Save Successfully");
                }
                case 2 ->
                        task = new RepeatableTask(userName, taskName, description, inputString("- Repeat: "), inputString("Data: "));
                case 3 -> task = new BasicTask(userName, taskName, description);
                default -> System.out.println(" - Input correct operation - ");
            }

        }
    }

    // View All model.Task
    static void viewAllTask() {
        System.out.println(TaskStorage.tasksMap);
    }

    // Update Concrete model.Task
    static void updateTask() {

    }

    // Delete Concrete model.Task
    static void deleteTask() {

    }

    // View Concrete model.Task
    static void viewTaskDetails() {
        System.out.println(TaskStorage.tasksMap.get(inputString("- Enter tasks.Task Name -: ")));
    }


    // ----------------------------------------------- Helper Functions ----------------------------------------
    static void printMainMenu() {
        System.out.println("""
                \n- Choose Operation - :\s
                1. Create tasks.Task
                2. View All tasks.Task
                3. Update tasks.Task
                4. Delete tasks.Task
                5. View tasks.Task Details
                0. Exit""");
    }

    static void printTaskTypeMenu() {
        System.out.println("""
                \n- Choose tasks.Task Type - :\s
                1. LimitedTimeTask
                2. Repeatable tasks.Task
                3. BasicTask
                0. <- Back
                """);
    }
}
