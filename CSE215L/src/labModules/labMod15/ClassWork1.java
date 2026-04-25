package labModules.labMod15;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassWork1 {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        Scanner input = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Enter integers (enter a negative number to stop):");
            while (true) {
                int num = input.nextInt();
                if (num < 0) {
                    break;
                }
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        int sum = 0;
        int count = 0;

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                sum += num;
                count++;
            }

            System.out.println("\n--- Results ---");
            System.out.println("Sum: " + sum);
            if (count > 0) {
                System.out.println("Average: " + (double) sum / count);
            } else {
                System.out.println("No non-negative numbers were entered.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }

        input.close();
    }
}