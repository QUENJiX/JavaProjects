import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class fileDemo {
    public static void main(String[] args) {
        // Directory Path and File String
        String TEXT_FILE = "Test.txt";
        String PATH_NAME = "D:\\AcademiX\\JavaProjects\\CSE215L\\lib\\Risha";

        // Create a Folder / Directory
        File dir = new File(PATH_NAME);
        dir.mkdir(); // make directory

        // Directory Path / Adress
        String path = dir.getAbsolutePath();
        System.out.println("Path: " + path);

        // Create Text File
        // D:\AcademiX\JavaProjects\CSE215L\lib\Risha + \\ + Test.txt
        File textFile = new File(PATH_NAME + "\\" + TEXT_FILE);
        try {
            textFile.createNewFile();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Write inside a Text File
        try {
            FileWriter writer = new FileWriter(PATH_NAME + "\\" + TEXT_FILE);
            writer.write("Risha is an annoying ass!\n");
            writer.write("Risha is fat as fuck!\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Read from a Text File
        try {
            FileReader reader = new FileReader(PATH_NAME + "\\" + TEXT_FILE);
            Scanner input = new Scanner(reader);

            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}