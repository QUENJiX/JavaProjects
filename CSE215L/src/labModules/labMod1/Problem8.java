package labModules.labMod1;

/* * Problem 8: Using the variables from Task 7, find the average of these three scores. 
 */
import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your three exam scores:");
        double score1 = input.nextDouble();
        double score2 = input.nextDouble();
        double score3 = input.nextDouble();

        // Calculating the average
        double averageScore = (score1 + score2 + score3) / 3;

        System.out.println("Average Exam Score: " + averageScore);

        input.close();
    }
}
