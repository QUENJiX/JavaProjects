import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileDemo {
    public static void main(String[] args) {
        String TEXT_FILE = "Test.txt";
        String PATH_NAME = "D:\\AcademiX\\JavaProjects\\CSE215L\\lib\\DemoFolder";

        // Create a Folder / Directory
        File dir = new File(PATH_NAME);
        dir.mkdir(); // make directory

        // Write inside a Text File
        try (FileWriter writer = new FileWriter(PATH_NAME + "\\" + TEXT_FILE)) {
            writer.write("Test Line 1\n");
            writer.write("Test Line 2\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Read from a Text File
        try (Scanner input = new Scanner(new FileReader(PATH_NAME + "\\" + TEXT_FILE))) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}