package practiceModules.square;

import java.util.Scanner;

public class SquareTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Square obj = new Square(5.0);
        
        System.out.println("Enter the side of the square: ");
        double side = input.nextDouble();
        obj.setSide(side);

        System.out.println("Side: " + obj.getSide());
        System.out.println("Area: " + obj.getArea());
        System.out.println("Perimeter: " + obj.getPerimeter());
        System.out.println("Diagonal: " + obj.getDiagonal());

        input.close();
    }
}
