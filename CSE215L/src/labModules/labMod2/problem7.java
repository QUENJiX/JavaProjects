/*Problem 7: Write a program that takes an integer and determines if it’s odd or even. Use switch cases
to produce results. */

package labModules.labMod2;

import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        switch (num % 2) {
            case 0 -> System.out.println("The number is even.");
            case 1, -1 -> System.out.println("The number is odd.");
            default -> System.out.println("Invalid input.");
        }
        input.close();
    }
}
