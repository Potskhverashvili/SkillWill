package Car;

public class Car {
    private String brand;
    private String model;
    private String engineType;
    private String gearBoxType;
    private String color;

    // Default constructor with initialization
    public Car() {
        brand = "Unknown";
        model = "Unknown";
        engineType = "Unknown";
        gearBoxType = "Unknown";
        color = "Unknown";
    }

    // Constructor with arguments
    public Car(String brand, String model, String engineType, String gearBoxType, String color) {
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.gearBoxType = gearBoxType;
        this.color = color;
    }

    // --------------------Setters ----------------------
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setGearBoxType(String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // ----------------------- Getters -----------------------------
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public String getColor() {
        return color;
    }
}
