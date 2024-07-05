class RepeateableTask extends Task {
    private int repetitions;
    private int intervalDays;

    public RepeateableTask(String name, String description, String username, int repetitions, int intervalDays) {
        super(name, description, username);
        this.repetitions = repetitions;
        this.intervalDays = intervalDays;
    }

    // ----------------------------------- Setters -----------------------------------
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    public void setIntervalDays(int intervalDays) {
        this.intervalDays = intervalDays;
    }

    @Override
    public String toString() {
        return super.toString() + ", repetitions=" + repetitions + ", intervalDays=" + intervalDays;
    }
}