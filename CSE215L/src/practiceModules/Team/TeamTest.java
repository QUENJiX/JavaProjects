package practiceModules.Team;

public class TeamTest {
    public static void main(String[] args) {
        Team myTeam = new Team("Confused Ballers", "Jaima", "Barishal");

        myTeam.addPlayer("Hasib");
        myTeam.addPlayer("Risha");
        myTeam.addPlayer("Fabiha");

        myTeam.printTeamInfo();

        myTeam.removePlayer("Fabiha");
        System.out.println("\n\nRemoving Fabiha...\n\n");
        myTeam.printTeamInfo();

    }
}
