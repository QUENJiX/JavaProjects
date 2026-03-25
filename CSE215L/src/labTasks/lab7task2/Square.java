package labTasks.lab7task2;

public class Square {
    private double side;

    // Default Constructor
    public Square() {
        this.side = 1.0;
    }

    // Parameterized Constructor
    public Square(double side) {
        this.side = side;
    }

    // Getter and Setter
    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // Logic Methods
    public double getArea() {
        return this.side * this.side;
    }

    public double getPerimeter() {
        return 4 * this.side;
    }

    public double getDiagonal() {
        return this.side * Math.sqrt(2);
    }
}
