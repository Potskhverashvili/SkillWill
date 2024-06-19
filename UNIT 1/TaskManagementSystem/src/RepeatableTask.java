public class RepeatableTask extends Task {
    String repeat;
    String data;

    public RepeatableTask(String userName, String taskName, String description, String repeat, String data) {
        super(userName, taskName, description);
        this.repeat = repeat;
        this.data = data;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "\nUser Name: " + userName +
                "\nTask Name:  " + taskName +
                "\nDescription :  " + description +
                "\nRepeat: " + repeat +
                "\nData: " + data;
    }
}
