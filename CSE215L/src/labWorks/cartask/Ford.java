package labWorks.cartask;

public class Ford extends Car {
    private boolean isAvailable;

    public Ford(String model, int price, boolean isAvailable) {
        super(model, price);
        this.isAvailable = isAvailable;
    }

    @Override
    public void startCar() {
        if (isAvailable) {
            System.out.println("Sarts roughly with weird sound...!");
        } else {
            System.out.println("Car is not avaiable.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Availability: " + isAvailable);
        System.out.println("Brand: Ford");
    }

    public void openTheBonet() {
        if (isAvailable) {
            System.out.println("Opens up the crazy V12 Engine!");
        } else {
            System.out.println("Car is not avaiable.");
        }
    }
}
