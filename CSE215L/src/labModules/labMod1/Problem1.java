package labModules.labMod1;

/* * Problem 1: Declare four variables (either all integers or all double values) and use user input for 
 * those numbers, then assign the summation to another variable and print that summation. 
 */
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creating Scanner instance

        // Declaring four double variables
        System.out.println("Enter four numbers (decimals allowed):");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();
        double num4 = input.nextDouble();

        // Assigning summation to another variable
        double sum = num1 + num2 + num3 + num4;

        // Printing the summation
        System.out.println("Summation: " + sum);

        input.close();
    }
}