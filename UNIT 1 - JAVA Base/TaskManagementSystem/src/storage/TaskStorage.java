package storage;

import model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskStorage {

    String taskName;
    Task task;
    public static Map<String, Task> tasksMap = new HashMap<>();

    public TaskStorage(String taskName, Task task) {
        this.taskName = taskName;
        this.task = task;
        tasksMap.put(taskName,task);
    }

}
