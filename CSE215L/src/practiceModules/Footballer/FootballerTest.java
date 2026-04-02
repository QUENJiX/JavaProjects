package practiceModules.Footballer;
import java.util.Scanner;

public class FootballerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Footballer p1 = new Footballer();
        p1.setName("Hasib");
        p1.setTeam("PSG");
        p1.setPosition("Left-Winger");

        Footballer p2 = new Footballer();
        p2.setName("Jaima");
        p2.setTeam("Manchaster City");
        p2.setPosition("Center-Forward");

        for(int i = 1; i <= 3; i++){
            System.out.println("\nMatch " + i + "/3");
            p1.increaseMatches();
            p2.increaseMatches();

            //Stats for Player 1
            System.out.println("\n--- Stats for " + p1.getName() + " ---");
            System.out.print("Enter goals for " + p1.getName() + ": ");
            p1.increaseGoals(input.nextInt());
            System.out.print("Enter assists for " + p1.getName() + ": ");
            p1.increaseAssists(input.nextInt());

            //Stats for Player 2
            System.out.println("\n--- Stats for " + p2.getName() + " ---");
            System.out.print("Enter goals for " + p2.getName() + ": ");
            p2.increaseGoals(input.nextInt());
            System.out.print("Enter assists for " + p2.getName() + ": ");
            p2.increaseAssists(input.nextInt());
        }

        System.out.println("\n--- Final Comparison ---");
        p1.compare(p2);

        input.close();
    }
}
