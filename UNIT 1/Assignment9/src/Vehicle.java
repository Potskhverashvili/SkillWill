public class Vehicle {

    // Private fields to encapsulate data and control access
    private String brand;
    private String modelName;
    private int releaseYear;

    // Constructor
    Vehicle(String brand, String modelName, int releaseYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
    }

    // ------------------------------- Setters ------------------------------
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    // -------------------------------- Getters -------------------------------
    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
