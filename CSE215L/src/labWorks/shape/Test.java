package labWorks.shape;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Area of shape: " + shape.getArea());

        Rectangle rectangle = new Rectangle(5, 3);
        System.out.println("Area of rectangle: " + rectangle.getArea());
    }
}
