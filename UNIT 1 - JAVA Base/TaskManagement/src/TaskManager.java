import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskManager {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Task> tasks = new HashMap<>();
    private static String currentUser;

    public static void main(String[] args) {
        System.out.print("Enter your username: ");
        currentUser = scanner.nextLine();

        while (true) {
            System.out.println("\nChoose a command:");
            System.out.println("1. Save a task");
            System.out.println("2. Retrieve all tasks");
            System.out.println("3. Update a specific task");
            System.out.println("4. Delete a specific task");
            System.out.println("5. Retrieve a specific task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    saveTask();
                    break;
                case 2:
                    retrieveAllTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    retrieveTask();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void saveTask() {
        System.out.print("Enter the task type (BasicTask, LimitedTimeTask, RepeateableTask): ");
        String taskType = scanner.nextLine();

        System.out.print("Enter the task name: ");
        String name = scanner.nextLine();

        // check
        if (tasks.containsKey(name)) {
            System.out.println("Task with this name already exists. Task names must be unique.");
            return;
        }

        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();

        Task task;
        switch (taskType) {
            case "LimitedTimeTask":
                System.out.print("Enter the deadline (yyyy-MM-ddTHH:mm): ");
                try {
                    LocalDateTime deadline = LocalDateTime.parse(scanner.nextLine());
                    task = new LimitedTimeTask(name, description, currentUser, deadline);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Task not created.");
                    return;
                }
                break;
            case "RepeateableTask":
                System.out.print("Enter the number of repetitions: ");
                int repetitions = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the repeat interval in days: ");
                int intervalDays = scanner.nextInt();
                scanner.nextLine();
                task = new RepeateableTask(name, description, currentUser, repetitions, intervalDays);
                break;

            case "BasicTask":
                task = new BasicTask(name, description, currentUser);
                break;
            default:
                System.out.println("Invalid task type.");
                return;
        }

        tasks.put(name, task);
        System.out.println("Task saved.");
    }

    public static void retrieveAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All tasks:");
            for (Task task : tasks.values()) {
                System.out.println(task.getName());
            }
        }
    }

    public static void updateTask() {
        System.out.print("Enter the task name to update: ");
        String name = scanner.nextLine();
        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        if (!task.getUsername().equals(currentUser)) {
            System.out.println("You can only update tasks you created.");
            return;
        }

        System.out.print("Enter the new task description: ");
        String newDescription = scanner.nextLine();
        task.setDescription(newDescription);

        if (task instanceof LimitedTimeTask) {
            LimitedTimeTask limitedTimeTask = (LimitedTimeTask) task;
            System.out.print("Enter the new deadline (yyyy-MM-ddTHH:mm): ");
            try {
                LocalDateTime newDeadline = LocalDateTime.parse(scanner.nextLine());
                limitedTimeTask.setDeadline(newDeadline);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Deadline not updated.");
            }
        } else if (task instanceof RepeateableTask) {
            RepeateableTask repeateableTask = (RepeateableTask) task;

            System.out.print("Enter the new number of repetitions: ");
            int newRepetitions = scanner.nextInt();
            scanner.nextLine(); // consume newline
            repeateableTask.setRepetitions(newRepetitions);

            System.out.print("Enter the new repeat interval in days: ");
            int newIntervalDays = scanner.nextInt();
            scanner.nextLine();
            repeateableTask.setIntervalDays(newIntervalDays);
        }

        System.out.println("Task updated.");
    }

    public static void deleteTask() {
        System.out.print("Enter the task name to delete: ");
        String name = scanner.nextLine();
        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        if (!task.getUsername().equals(currentUser)) {
            System.out.println("You can only delete tasks you created.");
            return;
        }
        tasks.remove(name);
        System.out.println("Task deleted.");
    }

    public static void retrieveTask() {
        System.out.print("Enter the task name to retrieve: ");
        String name = scanner.nextLine();
        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        System.out.println(task);
    }
}
