package labModules.labMod6;

/*
 * File Name: Footballer.java
 */
public class Footballer {
    // Data fields
    private String name;
    private String team;
    private String position;
    private int matches;
    private int goals;
    private int assists;

    // ONLY default constructor allowed
    public Footballer() {
        this.name = "";
        this.team = "";
        this.position = "";
        this.matches = 0;
        this.goals = 0;
        this.assists = 0;
    }

    // Get and Set methods for name, team, and position
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Methods to increase stats
    public void increaseMatches() {
        this.matches += 1; // Increases by 1; no parameters
    }

    public void increaseGoals(int addedGoals) {
        this.goals += addedGoals; // Increases by provided parameters
    }

    public void increaseAssists(int addedAssists) {
        this.assists += addedAssists; // Increases by provided parameters
    }

    // Method to compare stats with another footballer
    public void compareStats(Footballer other) { 
        if (this.goals > other.goals && this.assists > other.assists) {
            System.out.println(this.name + " has more goals and assists than " + other.name + ".");
        } else if (this.goals > other.goals && this.assists <= other.assists) {
            System.out.println(this.name + " has more goals but fewer or equal assists than " + other.name + ".");
        } else if (this.assists > other.assists && this.goals <= other.goals) {
            System.out.println(this.name + " has more assists but fewer or equal goals than " + other.name + ".");
        } else {
            System.out.println(this.name + " has fewer goals and assists than " + other.name + ".");
        }
    }
}
