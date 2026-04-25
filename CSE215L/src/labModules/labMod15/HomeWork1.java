package labModules.labMod15;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Quiz {
    int id;
    int mark;

    public Quiz(int id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "ID:" + id + " mark:" + mark;
    }
}

public class HomeWork1 {
    public static void main(String[] args) {
        String fileName = "quizzes.txt";

        Quiz[] quizArray = new Quiz[100];
        int count = 0;

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNextInt() && count < quizArray.length) {
                int studentId = fileScanner.nextInt();
                int studentMark = fileScanner.nextInt();
                quizArray[count] = new Quiz(studentId, studentMark);
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error: Could not read file. Make sure '" + fileName + "' exists.");
            return; 
        }

        if (count == 0) {
            System.out.println("No records were found in the file.");
            return;
        }

        int highestMark = -1;
        int topStudentId = -1;

        System.out.println("Program Output:");
        for (int i = 0; i < count; i++) {
            System.out.println(quizArray[i].toString());

            if (quizArray[i].mark > highestMark) {
                highestMark = quizArray[i].mark;
                topStudentId = quizArray[i].id;
            }
        }

        System.out.println("Highest mark obtained by ID:" + topStudentId);
    }
}
