package labWorks.cartask;

public class BMW extends Car {
    private boolean isAvailable;

    public BMW(String model, int price, boolean isAvailable) {
        super(model, price);
        this.isAvailable = isAvailable;
    }

    @Override
    public void startCar() {
        if (isAvailable) {
            System.out.println("Car starts smoothly, with satisfying sound!");
        } else {
            System.out.println("Car is not available.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Availability: " + isAvailable);
        System.out.println("Brand: BMW");
    }

    public void openTV() {
        if (isAvailable) {
            System.out.println("A 39-inch, 8K TV pops up for you to watch Netflix!");
        } else {
            System.out.println("Car is not available.");
        }
    }
}
