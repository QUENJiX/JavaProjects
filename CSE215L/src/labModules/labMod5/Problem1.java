package labModules.labMod5;

/* * Problem 1: Implement the following Class based on the provided UML Diagram and test the methods.
 * Square
 * - side : double
 * + Square()
 * + Square(s : double)
 * + setSide(s : double) : void
 * + getSide() : double
 * + getArea() : double
 * + getPerimeter() : double
 * + getDiagonal() : double
 */

class Square {
    private double side;

    // Default constructor
    public Square() {
        this.side = 1;
    }

    // Parameterized constructor
    public Square(double s) {
        this.side = s;
    }

    // Setter for side
    public void setSide(double s) {
        this.side = s;
    }

    // Getter for side
    public double getSide() {
        return this.side;
    }

    // Method to calculate area
    public double getArea() {
        return this.side * this.side;
    }

    // Method to calculate perimeter
    public double getPerimeter() {
        return 4 * this.side;
    }

    // Method to calculate diagonal (side * sqrt(2))
    public double getDiagonal() {
        return this.side * Math.sqrt(2);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        // Testing default constructor
        Square sq1 = new Square();
        System.out.println("Square 1 (Default):");
        System.out.println("Side: " + sq1.getSide());
        System.out.println("Area: " + sq1.getArea());

        // Testing parameterized constructor
        Square sq2 = new Square(5.0);
        System.out.println("\nSquare 2 (Parameterized):");
        System.out.println("Side: " + sq2.getSide());
        System.out.println("Perimeter: " + sq2.getPerimeter());
        System.out.printf("Diagonal: %.2f\n", sq2.getDiagonal());

        // Testing setter
        sq1.setSide(10.0);
        System.out.println("\nSquare 1 (After setSide):");
        System.out.println("New Side: " + sq1.getSide());
        System.out.println("New Area: " + sq1.getArea());
    }
}
