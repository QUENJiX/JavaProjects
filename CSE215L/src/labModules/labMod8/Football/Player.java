package labModules.labMod8.Football;

public class Player {
    private String name;
    private String club;
    private int matches;

    public Player() {
        this.matches = 0;
    }

    public Player(String name, String club) {
        this.name = name;
        this.club = club;
        this.matches = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setClub(String club) {
        System.out.println(this.name + " from " + this.club + " to " + club + ", here we go confirmed!");
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    public void playMatch() {
        this.matches++;
    }

    public int getMatches() {
        return matches;
    }

    public void displayInfo() {
        // As per PDF instructions (formatting mistake in original PDF saying "about
        // hotel room",
        // corrected here to fit Player attributes)
        System.out.println("Name: " + name);
        System.out.println("Club: " + club);
        System.out.println("Number of Matches: " + matches);
    }
}
