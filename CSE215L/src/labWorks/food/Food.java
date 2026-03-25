package labWorks.food;

public class Food {
    String name;
    double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Food: " + name);
        System.out.println("Price: $" + price);
    }
}
