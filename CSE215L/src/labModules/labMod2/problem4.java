/*Problem 4: Suppose you have gained a certain amount of points from a user input. You are tasked to
find the number of points raised to the power of half and then print the final results. */

package labModules.labMod2;

import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter points: ");
        int points = input.nextInt();

        System.out.println(Math.sqrt(points));
        input.close();
    }
}
