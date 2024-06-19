import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Map<String, Task > tasksMap = new HashMap<>();



        LimitedTimeTask myTask1 = new LimitedTimeTask("user1", "task1" , inputString("Enter desc."), "24/06");
        LimitedTimeTask myTask2 = new LimitedTimeTask("user1", "task2" , "this is my task 2", "24/06");

        tasksMap.put(myTask1.taskName, myTask1);
        tasksMap.put(myTask2.taskName, myTask2);

        System.out.println(tasksMap.get("task1"));






    }

    static String inputString(String txt) {
        Scanner input = new Scanner(System.in);
        System.out.print(txt);
        return input.nextLine();
    }
}
