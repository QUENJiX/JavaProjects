package labModules.labMod15;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassWork2 {
    public static void main(String[] args) {
        String fileName = "lines.txt";
        Scanner input = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Enter lines of text (type 'STOP' on a new line to finish):");
            while (true) {
                String line = input.nextLine();
                if (line.equals("STOP")) {
                    break;
                }
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        int nonEmptyCount = 0;
        System.out.println("\n--- Content of lines.txt ---");

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                if (!line.trim().isEmpty()) {
                    nonEmptyCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }

        System.out.println("\nTotal number of non-empty lines: " + nonEmptyCount);
        input.close();
    }
}