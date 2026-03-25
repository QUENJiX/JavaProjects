package labModules.labMod2;

import java.util.Scanner;

public class problem8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c;

        System.out.print("Enter three integers: ");
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        System.out.println("Press '1' for addition of numbers");
        System.out.println("Press '2' for the subtraction of other numbers from the maximum");
        System.out.println("Press '3' for the multiplication of numbers");

        int choice = input.nextInt();
        int max;
        switch (choice) {
            case 1 -> System.out.println("The sum: " + (a + b + c));
            case 2 -> {
                max = Math.max(a, Math.max(b, c));
                System.out.println("Result: " + (max - (a + b + c - max)));
            }
            case 3 -> System.out.println("The product: " + (a * b * c));
            default -> System.out.println("Invalid choice.");

        }
        input.close();
    }
}
