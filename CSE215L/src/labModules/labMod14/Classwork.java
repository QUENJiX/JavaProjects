package labModules.labMod14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Classwork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Task 1: 10 Positive Integers ---");
        int sum = 0;
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("Enter positive integer " + (count + 1) + ": ");
                int num = input.nextInt();

                if (num < 0) {
                    throw new IllegalArgumentException("Input positive integer only");
                }

                sum += num;
                count++;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type! Please enter an integer.");
                input.next();
            }
        }
        System.out.println("Sum of the 10 positive integers: " + sum);

        System.out.println("\n--- Task 2: Array Index Out of Bounds ---");
        int[] randomArray = new int[100];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 10000);
        }

        try {
            System.out.print("Enter an array index (0-99) to view its element: ");
            int index = input.nextInt();
            System.out.println("Element at index " + index + " is: " + randomArray[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: The index you entered is out of array size limits!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type!");
        }

        input.close();
    }
}