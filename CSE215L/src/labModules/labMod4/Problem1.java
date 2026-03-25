package labModules.labMod4;

/* * Problem 1: Create a method named int sumOfSquares(int n) which returns the summation of squares 
 * from 1 to n where the value of n is from the user input.
 */
import java.util.Scanner;

public class Problem1 {

    // Method to calculate the sum of squares
    public static int sumOfSquares(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (i * i); // Adding the square of the current number to sum
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer n: ");
        int n = input.nextInt();

        // Calling the method and storing the result
        int result = sumOfSquares(n);

        System.out.println("The summation of squares from 1 to " + n + " is: " + result);

        input.close();
    }
}
