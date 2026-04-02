package practiceModules.Team;

public class Team {
    private String teamName;
    private String coachName;
    private String homeCountry;
    private String[] players;
    private int currentPlayerCount = 0;

    private static final int MAX_PLAYERS = 7;

    public Team(String teamName, String coachName, String homeCountry) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.homeCountry = homeCountry;
        this.players = new String[MAX_PLAYERS];
    }

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

    public void addPlayer(String playerName) {
        players[currentPlayerCount] = playerName;
        currentPlayerCount++;
    }

    public void removePlayer(String playername) {
        for (int i = 0; i < currentPlayerCount; i++) {
            if (players[i].equalsIgnoreCase(playername)) {
                for (int j = i; j < currentPlayerCount - 1; j++) {
                    players[j] = players[j + 1];
                }
                players[currentPlayerCount - 1] = null;
                currentPlayerCount--;
                break;
            }
        }
    }

    public void printTeamInfo() {
        System.out.println("--- Team Info ---");
        System.out.println("Team Name: " + teamName);
        System.out.println("Coach Name: " + coachName);
        System.out.println("Home Country: " + homeCountry);
        System.out.println("\nPlayers: ");
        for (int i = 0; i < currentPlayerCount; i++) {
            System.out.println(players[i]);
        }
    }

}
