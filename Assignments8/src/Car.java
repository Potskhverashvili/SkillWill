public class Car {
    String brandName;
    String color;

    public Car(String brandName, String color) {
        this.brandName = brandName;
        this.color = color;
    }


    @Override
    public String toString() {
        return brandName + color;
    }
}
