package labModules.labMod1;

/* * Problem 2: Declare three variables (all float values) and use user input for those numbers, then assign 
 * the product to another variable and print the product. 
 */
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaring three float variables
        System.out.println("Enter three float numbers:");
        float f1 = input.nextFloat();
        float f2 = input.nextFloat();
        float f3 = input.nextFloat();

        // Assigning product to another variable
        float product = f1 * f2 * f3;

        // Printing the product
        System.out.println("Product: " + product);

        input.close();
    }
}