package labModules.labMod11;

public class MartialArtist extends Combatant {

    public MartialArtist() {
    }

    public MartialArtist(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k) {
        int additionalDamage = (int) (5 * Math.random());
        int totalDamage = 10 + additionalDamage;

        System.out.println(
                getName() + " has performed the Majhi Smacker to " + k.getName() + " by " + totalDamage + " points.");
        k.healthDeplete(totalDamage);

        if (k.getHealth() <= 0) {
            System.out.println(getName() + " wins");
        }
    }
}