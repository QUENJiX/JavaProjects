package labModules.labMod1;

/* * Problem 3: Find the difference between the summation (found in task 1) and product (found in task 
 * 2), and print that difference. 
 */
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking previous results as input to keep this code standalone
        System.out.print("Enter the summation from Task 1: ");
        double sum = input.nextDouble();

        System.out.print("Enter the product from Task 2: ");
        double product = input.nextDouble();

        // Finding the difference
        double difference = sum - product;

        // Printing the difference
        System.out.println("Difference (Sum - Product): " + difference);

        input.close();
    }
}
