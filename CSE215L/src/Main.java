import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputCount = 0;
        int sum = 0;

        while (inputCount < 10) {
            try {
                System.out.print("\nEnter a positive integer: ");
                int num = input.nextInt();
                if (num < 0) {
                    throw new IllegalArgumentException("Enter positve integers only.");
                }
                sum += num;
                inputCount++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                input.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("\nThe sum is: " + sum);
        input.close();
    }
}
