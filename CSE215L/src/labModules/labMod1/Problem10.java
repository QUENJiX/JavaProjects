package labModules.labMod1;

/* * Problem 10: Print the name and recent average score in the SAME LINE. 
 */
import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Requesting the name
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        // Requesting the recent average score
        System.out.print("Enter your recent average score: ");
        double recentAverage = input.nextDouble();

        // Printing both in the same line using string concatenation
        System.out.println("Name: " + name + " | Recent Average Score: " + recentAverage);

        input.close();
    }
}
