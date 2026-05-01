package labModules.labMod15;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassWork1 {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        Scanner input = new Scanner(System.in);

        // Default Write Structure
        /* 
        try(FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Enter Data:");
            while (true){
                Take Input

                if(Stopping Argument){
                    break;
                }
                writer.write("Input Data\n");
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        */


        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.print("Enter integers (enter a negative number to stop): ");
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
        int count = 0;

        // Default Write Structure
        /* 
        try(Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            System.out.println("Enter Data:");
            while (fileScanner.hasNextLine()) {
                Read Data
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        */

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                sum += num;
                count++;
            }

            System.out.println("\n--- Results ---");
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (double) sum / count);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.close();
    }
}