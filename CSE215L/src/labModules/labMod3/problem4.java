package labModules.labMod3;

/*
 * Problem 4: Declare an integer array of size 10, initialize it with user input, 
 * and calculate and print the average.
 */
import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        int sum = 0;

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Input " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i]; // Add to sum dynamically
        }

        // Calculate average (cast sum to double for decimal precision)
        double average = (double) sum / numbers.length;

        System.out.println("The average of the array is: " + average);
        input.close();
    }
}
