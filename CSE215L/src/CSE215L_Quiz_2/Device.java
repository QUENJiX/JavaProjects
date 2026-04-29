package CSE215L_Quiz_2;

public abstract class Device {
    private String modelName;
    private double basePrice;

    public Device(String modelName, double basePrice){
        this.modelName = modelName;
        this.basePrice = basePrice;
    }

    public String getModelName() { return this.modelName; }
    public void setModelName(String name) { this.modelName = name; }

    public double getBasePrice() { return this.basePrice; }
    public void set(int basePrice) { this.basePrice = basePrice; }

    public abstract void displaySpecs();
    public abstract double calculateFinalPrice();

}
