package labWorks.cartask;

public class Car {
    protected String model;
    protected int price;

    public Car(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public void startCar() {
        System.out.println("Generic car sound!");
    }

    public void buyCar() {
        System.out.println(model + " has been bought for $" + price);
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
