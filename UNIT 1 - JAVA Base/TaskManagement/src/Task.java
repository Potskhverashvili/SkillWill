 abstract  class Task {
    private String name;
    private String description;
    private String username;

    public Task(String name, String description, String username) {
        this.name = name;
        this.description = description;
        this.username = username;
    }

    // ---------------------------- Getters ----------------------
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }

    // ---------------------------- Setter -----------------------
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created by='" + username + '\'' +
                '}';
    }
}
