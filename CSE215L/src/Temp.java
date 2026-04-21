import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        String TEXT_FILE = "File.txt";
        File dir = new File("Record");
        dir.mkdir();

        String path = dir.getAbsolutePath();
        System.out.println("Path: " + path);

        File textFile = new File(TEXT_FILE); 
        try {
            textFile.createNewFile();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter(TEXT_FILE);
            writer.write("Hello world\n");
            writer.close();
            System.out.println("Written to " + TEXT_FILE);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try {
            FileReader reader = new FileReader(TEXT_FILE);
            Scanner fScanner = new Scanner(reader);
            while (fScanner.hasNext()) {
                System.out.println(fScanner.nextLine());
            }
            fScanner.close();
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage());
        }
    }
}
