package labModules.labMod4;

/* * Problem 2: Recreate the max(int m, int n) method from the Math class (covered in Lab 3), but this 
 * time, YOU ARE BANNED FROM USING MATH CLASS FOR THIS ONE.
 */
import java.util.Scanner;

public class Problem2 {

    // Recreating the max method using conditional statements
    public static int max(int m, int n) {
        if (m > n) {
            return m;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter two integers to compare:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        // Calling our custom max method
        int maximum = max(num1, num2);

        System.out.println("The maximum value is: " + maximum);

        input.close();
    }
}
