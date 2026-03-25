package labModules.labMod1;

/* * Problem 7: Declare THREE variables that store exam scores and use user input to assign their values. 
 * (Use proper Data Type to store exam scores). 
 */
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Using double to allow for fractional scores (proper data type)
        System.out.println("Enter three exam scores:");
        double score1 = input.nextDouble();
        double score2 = input.nextDouble();
        double score3 = input.nextDouble();

        System.out.println("Scores successfully recorded: " + score1 + ", " + score2 + ", " + score3);

        input.close();
    }
}
