/* Problem 2: Print the Fibonacci Sequence from 0 to n, where n is user input. Fibonacci series progress
in this manner -> 0, 1, 1, 2, 3, 5, 8, 13, 21….. */

package labModules.labMod3;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        int first = 0, second = 1;
        System.out.print("Fibonacci series upto " + n + ": ");
        /*
         * How to print Fibonacci series:
         * Start with the first two numbers (0 and 1).
         * Print the first number (0).
         * Calculate the next number by adding the last two numbers (0 + 1 = 1).
         * Update the last two numbers (first = 1, second = 1).
         * Repeat the process until the next number exceeds n.
         */
        while (first <= n) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
        input.close();
    }

}
