public class Car {

    private String model;
    private String engineType;
    private String gearBoxType;
    private String bodyStyle;
    private String color;

    public Car() {

    }

    public Car(String model, String engineType, String gearBoxType, String bodyStyle, String color) {
        this.model = model;
        this.engineType = engineType;
        this.gearBoxType = gearBoxType;
        this.bodyStyle = bodyStyle;
        this.color = color;
    }

    // --------------------Setters ----------------------
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

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    // ----------------------- Getters -----------------------------

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public String getColor() {
        return color;
    }
}
