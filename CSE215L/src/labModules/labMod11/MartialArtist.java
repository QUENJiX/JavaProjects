package labModules.labMod11;

/*
 * File Name: MartialArtist.java
 */
public class MartialArtist extends Combatant {

    public MartialArtist() {
        super();
    }

    public MartialArtist(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k) {
        // Base damage 10, additional damage 0 to 5
        // Using Math.round to ensure the value can actually reach the maximum of 5 as
        // per x*Math.random() logic
        int additionalDamage = (int) Math.round(5 * Math.random()); // [cite: 1007, 1015]
        int totalDamage = 10 + additionalDamage; // [cite: 1014]

        System.out.println(this.getName() + " has performed the Majhi Smacker to "
                + k.getName() + " by " + totalDamage + " points."); // [cite: 1008]

        k.healthDeplete(totalDamage); // [cite: 1024]

        if (k.getHealth() <= 0) {
            System.out.println(this.getName() + " wins"); // [cite: 1025, 1026]
        }
    }
}
