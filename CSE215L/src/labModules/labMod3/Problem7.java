package labModules.labMod3;

/*
 * Problem 7: 2D array to store the marks of 4 students for 5 subjects. 
 * Input validation included (0-100). Calculate averages and highest earners.
 */
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int students = 4;
        int subjects = 5;
        int[][] marks = new int[students][subjects];

        // Taking User Input with validation
        for (int i = 0; i < students; i++) {
            System.out.println("--- Entering marks for Student " + (i + 1) + " ---");
            for (int j = 0; j < subjects; j++) {
                int score = -1;
                // Validation loop: runs until a valid score is entered
                while (score < 0 || score > 100) {
                    System.out.print("Enter Subject " + (j + 1) + " score (0-100): ");
                    score = input.nextInt();

                    if (score < 0 || score > 100) {
                        System.out.println("Invalid input! Marks must be between 0 and 100. Please retype.");
                    }
                }
                marks[i][j] = score; // Assign valid score
            }
            System.out.println();
        }

        // a. Print the whole result in a tabular manner
        System.out.println("============== TABULAR RESULT ==============");
        System.out.print("          \t");
        for (int j = 0; j < subjects; j++) {
            System.out.print("Sub " + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < students; i++) {
            System.out.print("Student " + (i + 1) + ":\t");
            for (int j = 0; j < subjects; j++) {
                System.out.print(marks[i][j] + "\t");
            }
            System.out.println();
        }

        // b. Find the average score from each student for all subjects
        System.out.println("\n--- Average Score per Student ---");
        for (int i = 0; i < students; i++) {
            int studentSum = 0;
            for (int j = 0; j < subjects; j++) {
                studentSum += marks[i][j];
            }
            double studentAvg = (double) studentSum / subjects;
            System.out.println("Student " + (i + 1) + ": " + studentAvg);
        }

        // c & d. Find the average score and highest mark earner for each subject
        System.out.println("\n--- Subject Analysis ---");
        for (int j = 0; j < subjects; j++) {
            int subjectSum = 0;
            int highestMark = -1;
            int topStudent = -1;

            for (int i = 0; i < students; i++) {
                subjectSum += marks[i][j];

                // Checking for highest mark
                if (marks[i][j] > highestMark) {
                    highestMark = marks[i][j];
                    topStudent = i + 1; // +1 to convert index to student number
                }
            }

            double subjectAvg = (double) subjectSum / students;
            System.out.println("Subject " + (j + 1) + " Average: " + subjectAvg);
            System.out.println(
                    "Subject " + (j + 1) + " Highest Earner: Student " + topStudent + " (" + highestMark + " marks)\n");
        }

        input.close();
    }
}
