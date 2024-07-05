import java.time.LocalDateTime;

 class LimitedTimeTask extends Task {
    private LocalDateTime deadline;

    public LimitedTimeTask(String name, String description, String username, LocalDateTime deadline) {
        super(name, description, username);
        this.deadline = deadline;
    }

    // ----------------------------------- Setter ------------------------------
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + ", deadline=" + deadline;
    }
}

