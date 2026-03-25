package labWorks.shape;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        System.out.println("Calculating area of a rectangle...");
        return width * height;
    }
}