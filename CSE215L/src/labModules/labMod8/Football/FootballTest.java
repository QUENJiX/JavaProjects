package labModules.labMod8.Football;

public class FootballTest {
    public static void main(String[] args) {
        // 1. Goalkeeper Task
        System.out.println("--- Goalkeeper Simulation ---");
        Goalkeeper alisson = new Goalkeeper("Alisson Becker", "Liverpool");
        System.out.println("\n[Match 1 Input] Please enter '2' when prompted:");
        alisson.playMatch();
        System.out.println("\n[Match 2 Input] Please enter '0' when prompted:");
        alisson.playMatch();

        System.out.println("\n>> Alisson's Details:");
        alisson.displayInfo();

        System.out.println("\n=============================================\n");

        // 2. Defender Task
        System.out.println("--- Defender Simulation ---");
        Defender lisandro = new Defender("Lisandro Martinez", "Manchester United");

        System.out.println("\n[Match 1 Input] Please enter '3' blocks and '2' tackles:");
        lisandro.playMatch();

        System.out.println("\n[Match 2 Input] Please enter '2' blocks and '1' tackle:");
        lisandro.playMatch();

        System.out.println("\n[Match 3 Input] Please enter '4' blocks and '3' tackles:");
        lisandro.playMatch();

        System.out.println("\n[Match 4 Input] Please enter '5' blocks and '2' tackles:");
        lisandro.playMatch();

        System.out.println("\n>> Lisandro's Details:");
        lisandro.displayInfo();
    }
}
