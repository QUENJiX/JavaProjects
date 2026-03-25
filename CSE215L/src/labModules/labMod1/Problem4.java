package labModules.labMod1;

/* * Problem 4: Find the average of the summation (task 1) and product (task 2), followed by printing its 
 * square. 
 */
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the summation from Task 1: ");
        double sum = input.nextDouble();

        System.out.print("Enter the product from Task 2: ");
        double product = input.nextDouble();

        // Finding the average
        double average = (sum + product) / 2;

        // Finding the square of the average
        double square = average * average;

        System.out.println("Average: " + average);
        System.out.println("Square of the average: " + square);

        input.close();
    }
}