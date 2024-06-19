import java.time.LocalDateTime;

public class LimitedTimeTask extends Task {

    //TODO deadline date LocalDataTime
    String deadLine;
    LocalDateTime localDateTime = LocalDateTime.now();

    LimitedTimeTask(String userName, String taskName, String description, String deadLine) {
        super(userName, taskName, description);
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "\nUser Name: " + userName +
                "\nTask Name:  " + taskName +
                "\nDescription :  " + description +
                "\nDeadline: " + deadLine;
    }
}
