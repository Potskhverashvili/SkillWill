package model;

import java.time.LocalDateTime;
public class LimitedTimeTask extends Task {
    //TODO deadline date LocalDataTime
    String deadLine;
    LocalDateTime localDateTime = LocalDateTime.now();

    public LimitedTimeTask(String userName, String taskName, String description, String deadline) {
        super(userName, taskName, description);
        this.deadLine = deadline;
    }

    public void setDeadline(String deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "\nUser Name: " + userName +
                "\ntasks.Task Name:  " + taskName +
                "\nDescription :  " + description +
                "\nDeadline: " + deadLine;
    }


}
