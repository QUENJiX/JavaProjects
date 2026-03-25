package labModules.labMod4;

/* * Problem 5: Print the Fibonacci Sequence from 0 to n using a method where n is user input. 
 * The method created should be named void Fibonacci(int n) which returns no value, just prints. 
 */
import java.util.Scanner;

public class Problem5 {

    // Method to print Fibonacci sequence up to the value 'n'
    public static void Fibonacci(int n) {
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.print("Fibonacci sequence up to " + n + ": ");

        while (firstTerm <= n) {
            System.out.print(firstTerm + " ");

            // Calculate the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum limit (n) for the Fibonacci sequence: ");
        int n = input.nextInt();

        Fibonacci(n);

        input.close();
    }
}