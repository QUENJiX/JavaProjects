/*Problem 1: (Using while loop) Take an integer (n) through user input and print the summation of all
numbers from zero to n */

package labModules.labMod3;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        int sum = 0;
        while (n != 0) {
            sum += n;
            n--;
        }
        System.out.println("The sum is: " + sum);

        input.close();
    }
}
