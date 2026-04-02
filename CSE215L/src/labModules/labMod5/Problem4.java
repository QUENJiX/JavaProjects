package labModules.labMod5;

/* * Problem 4: Create a Team class with team, coach, country names, and a maximum of 7 players.
 * Include methods to add, remove, and print player information.
 */

class Team {
    private String teamName;
    private String coachName;
    private String homeCountry;
    private String[] players;
    private int currentNumberOfPlayers;
    private final int MAX_PLAYERS = 7; // Constant max limit

    // Constructor
    public Team(String teamName, String coachName, String homeCountry) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.homeCountry = homeCountry;
        this.players = new String[MAX_PLAYERS];
        this.currentNumberOfPlayers = 0; // Starts at zero
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    // Method to add a player
    public void addPlayer(String playerName) {
        if (currentNumberOfPlayers < MAX_PLAYERS) {
            players[currentNumberOfPlayers] = playerName;
            currentNumberOfPlayers++;
            System.out.println(playerName + " added to the team.");
        } else {
            System.out.println("Cannot add " + playerName + ". Team is full (Max 7 players).");
        }
    }

    // Method to remove a player
    public void removePlayer(String playerName) {
        boolean found = false;
        for (int i = 0; i < currentNumberOfPlayers; i++) {
            if (players[i].equalsIgnoreCase(playerName)) {
                found = true;
                // Shift remaining players to the left to fill the gap
                for (int j = i; j < currentNumberOfPlayers - 1; j++) {
                    players[j] = players[j + 1];
                }
                // Clear the last slot and decrement counter
                players[currentNumberOfPlayers - 1] = null;
                currentNumberOfPlayers--;
                System.out.println(playerName + " removed from the team.");
                break;
            }
        }
        if (!found) {
            System.out.println("Player " + playerName + " not found on the team.");
        }
    }

    // Method to print team information
    public void printTeamInfo() {
        System.out.println("\n--- Team Information ---");
        System.out.println("Team Name: " + teamName);
        System.out.println("Coach: " + coachName);
        System.out.println("Home Country: " + homeCountry);
        System.out.println("Players (" + currentNumberOfPlayers + "/" + MAX_PLAYERS + "):");

        if (currentNumberOfPlayers == 0) {
            System.out.println("  No players currently assigned.");
        } else {
            for (int i = 0; i < currentNumberOfPlayers; i++) {
                System.out.println("  " + (i + 1) + ". " + players[i]);
            }
        }
        System.out.println("------------------------\n");
    }
}

public class Problem4 {
    public static void main(String[] args) {
        // Initialize the object
        Team myTeam = new Team("Strikers", "Coach Carter", "Bangladesh");

        // Print empty team info
        myTeam.printTeamInfo();

        // Add players
        myTeam.addPlayer("Player 1");
        myTeam.addPlayer("Player 2");
        myTeam.addPlayer("Player 3");
        myTeam.addPlayer("Player 4");
        myTeam.addPlayer("Player 5");
        myTeam.addPlayer("Player 6");
        myTeam.addPlayer("Player 7");

        // Try adding an 8th player (should fail)
        myTeam.addPlayer("Player 8");

        // Print full team info
        myTeam.printTeamInfo();

        // Remove a player and show updated roster
        myTeam.removePlayer("Player 3");
        myTeam.printTeamInfo();
    }
}
