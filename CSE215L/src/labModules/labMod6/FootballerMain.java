package labModules.labMod6;

/*
 * File Name: Lab6Main.java
 * Note: Keep this in the same folder as Footballer.java
 */
import java.util.Scanner;

public class FootballerMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating Player 1
        Footballer player1 = new Footballer();
        player1.setName("Kylian Mbappe");
        player1.setTeam("PSG");
        player1.setPosition("Left-Winger");

        // Creating Player 2
        Footballer player2 = new Footballer();
        player2.setName("Erling Haaland");
        player2.setTeam("Manchester City");
        player2.setPosition("Center-Forward");

        System.out.println("Enter match statistics for 3 matches as per the table pattern:");

        // Loop for 3 matches
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Match " + i + " ---");

            // Player 1 Input
            System.out.print("Enter Goals for Kylian Mbappe: ");
            int p1Goals = input.nextInt();
            System.out.print("Enter Assists for Kylian Mbappe: ");
            int p1Assists = input.nextInt();

            player1.increaseMatches();
            player1.increaseGoals(p1Goals);
            player1.increaseAssists(p1Assists);

            // Player 2 Input
            System.out.print("Enter Goals for Erling Haaland: ");
            int p2Goals = input.nextInt();
            System.out.print("Enter Assists for Erling Haaland: ");
            int p2Assists = input.nextInt();

            player2.increaseMatches();
            player2.increaseGoals(p2Goals);
            player2.increaseAssists(p2Assists);
        }

        System.out.println("\n--- Final Comparison ---");
        // Compare their goals and assists
        player1.compareStats(player2);

        input.close();
    }
}
