package labWorks.cartask;

public class CarTest {
    public static void main(String[] args) {
        Car randomCar = new Car("Generic Car", 0);
        Ford ford = new Ford("Mustang", 1000, false);
        BMW bmw = new BMW("BMW-i7", 2000, true);

        System.out.println("---Car Information---");
        randomCar.displayInfo();
        System.out.println("");
        ford.displayInfo();
        System.out.println();
        bmw.displayInfo();

        System.out.println("---Car Starting---");
        randomCar.startCar();
        ford.startCar();
        bmw.startCar();
    }
}
