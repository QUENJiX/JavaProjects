package labModules.labMod8.Football;

import java.util.Scanner;

public class Goalkeeper extends Player {
    private int cleanSheets;
    private int goalsConceded;

    public Goalkeeper() {
        super();
        this.cleanSheets = 0;
        this.goalsConceded = 0;
    }

    public Goalkeeper(String name, String club) {
        super(name, club);
        this.cleanSheets = 0;
        this.goalsConceded = 0;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    @Override
    public void playMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter goals conceded FOR THE MATCH by " + getName() + ": ");
        int matchGoals = scanner.nextInt();

        if (matchGoals == 0) {
            this.cleanSheets++;
        }

        this.goalsConceded += matchGoals;
        super.playMatch(); // Increase matches by 1

        scanner.close();
    }

    public double getGoalsConcededPerMatch() {
        if (getMatches() == 0)
            return 0;
        return (double) goalsConceded / getMatches();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Goals Conceded: " + goalsConceded);
        System.out.println("Total Clean Sheets: " + cleanSheets);
        System.out.printf("Goals Conceded per Match: %.2f\n", getGoalsConcededPerMatch());
    }
}
