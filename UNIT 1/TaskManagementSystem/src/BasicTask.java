import com.sun.source.tree.UsesTree;

public class BasicTask extends Task {
    public BasicTask(String userName, String taskName, String description) {
        super(userName, taskName, description);
    }


    @Override
    public String toString() {
        return "\nUser Name: " + userName +
                "\nTask Name:  " + taskName +
                "\nDescription :  " + description;
    }
}
