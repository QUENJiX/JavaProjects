package labModules.labMod1;

/* * Problem 9: Give an individual singular increase in exam scores and find the new average score of the 
 * updated scores. 
 */
import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your three original exam scores:");
        double score1 = input.nextDouble();
        double score2 = input.nextDouble();
        double score3 = input.nextDouble();

        // Applying a singular increase (e.g., a 5-point bonus curve to all scores)
        double scoreIncrease = 5.0;
        score1 += scoreIncrease;
        score2 += scoreIncrease;
        score3 += scoreIncrease;

        // Calculating the new updated average
        double newAverage = (score1 + score2 + score3) / 3;

        System.out.println("Updated Scores: " + score1 + ", " + score2 + ", " + score3);
        System.out.println("New Average Score after increase: " + newAverage);

        input.close();
    }
}