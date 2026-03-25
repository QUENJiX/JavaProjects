package labModules.labMod1;

/* * Problem 5: Divide the result in Task 4 by 4 and print the divided value minus 1. 
 */
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking the square result from Task 4 as input
        System.out.print("Enter the squared result from Task 4: ");
        double squareResult = input.nextDouble();

        // Dividing by 4
        double dividedValue = squareResult / 4;

        // Subtracting 1
        double finalValue = dividedValue - 1;

        System.out.println("Final Result: " + finalValue);

        input.close();
    }
}