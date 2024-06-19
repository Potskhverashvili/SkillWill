public class Task {
    String userName;
    String taskName;
    String description;

    public Task(String userName, String taskName, String description) {
        this.userName = userName;
        this.taskName = taskName;
        this.description = description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
