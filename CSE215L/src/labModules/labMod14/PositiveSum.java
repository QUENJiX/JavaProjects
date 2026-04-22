package labModules.labMod14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PositiveSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while (count < 10) {
            try {
                int num = input.nextInt();
                if (num < 0) {
                    throw new IllegalArgumentException("Input positive integer only");
                }
                sum += num;
                count++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                input.next();
            }
        }
        System.out.println(sum);
        input.close();
    }
}