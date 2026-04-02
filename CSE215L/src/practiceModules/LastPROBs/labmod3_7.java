package practiceModules.LastPROBs;

import java.util.Scanner;

public class labmod3_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int students = 2;
        int subjects = 2;
        int[][] marks = new int[students][subjects];

        for (int i = 0; i < students; i++) {
            System.out.println("Student " + (i + 1) + ": ");
            for (int j = 0; j < subjects; j++) {
                do {
                    System.out.print("Enter subject " + (j + 1) + " score (0-100): ");
                    marks[i][j] = input.nextInt();
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }
            System.out.println();
        }

        // a. Result in Tabular Manner
        System.out.println("Result in Tabular Manner: ");
        System.out.print("        \t");
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

        // b. Average Score From Each Student For All Subjects
        System.out.println("\nAverga Score per Student");
        for (int i = 0; i < students; i++) {
            int studentMarksSum = 0;
            for (int j = 0; j < subjects; j++) {
                studentMarksSum += marks[i][j];
            }
            double studentAvg = (double) studentMarksSum / subjects;
            System.out.println("Student " + (i + 1) + ": " + studentAvg);
        }

        // c.,d.
        System.out.println("\nAverga Score per Subject");
        for (int j = 0; j < subjects; j++) {
            int subjectMarkSum = 0;
            int highestMark = -1;
            int topStudent = -1;

            for (int i = 0; i < students; i++) {
                subjectMarkSum += marks[i][j];

                if (marks[i][j] > highestMark) {
                    highestMark = marks[i][j];
                    topStudent = i + 1;
                }
            }
            double subjectAvg = (double) subjectMarkSum / students;
            System.out.println("Subject " + (j + 1) + " Average." + subjectAvg);
            System.out.println(
                    "Subject " + (j + 1) + " Highest Earner: Student " + topStudent + " (" + highestMark + " marks)\n");
        }
        input.close();
    }
}
