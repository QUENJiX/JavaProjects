package practiceModules.practice_LabMod11;

public class MartialArtist extends Combatant {
    public MartialArtist() {
        super();
    }public MartialArtist(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k) {
        int additionalDamage = (int) Math.round(5 * Math.random());
        int totalDamage = 10 + additionalDamage;

        System.out.println(this.getName() + " has performed the Majhi Smacker to " + k.getName() + " by " + totalDamage + " points.");

        k.healthDeplete(totalDamage);
        if (k.getHealth() <= 0) {
            System.out.println(this.getName() + " wins");
        }
    }
}
