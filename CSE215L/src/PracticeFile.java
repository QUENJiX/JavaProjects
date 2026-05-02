import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PracticeFile {
    public static void main(String[] args) {
        String fileName = "texts.txt";
        Scanner input = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Enter integer: ");
            while (true) {
                int num = input.nextInt();
                if (num < 0) {
                    break;
                }
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int sum = 0;
        int intCount = 0;
        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                sum += num;
                intCount++;
            }
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (double) sum / intCount);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.close();
    }
}
