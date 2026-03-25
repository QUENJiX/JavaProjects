package labTasks.lab7task2;

public class Lab7Task2 {
    public static void main(String[] args) {
        Square pizzaBox = new Square();
        Square biriyaniBox = new Square(5.5);

        System.out.println("--- Square Properties ---");
        System.out.println("Pizza box area: " + pizzaBox.getArea());
        System.out.println("Biriyani box perimeter: " + biriyaniBox.getPerimeter());
        // Used %n instead of \n for platform-independent line breaks
        System.out.printf("Biriyani box diagonal: %.2f%n", biriyaniBox.getDiagonal());

        System.out.println("\n--- Updating Pizza Box ---");
        pizzaBox.setSide(2.0);
        System.out.println("Pizza box new side: " + pizzaBox.getSide());
    }
}
