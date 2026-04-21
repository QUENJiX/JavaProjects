package labModules.labMod11;

public class SuperSoldier extends Combatant {

    public SuperSoldier() {
    }

    public SuperSoldier(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k) {
        int additionalDamage = (int) (10 * Math.random());
        int totalDamage = 8 + additionalDamage;

        System.out.println(getName() + " has caused " + totalDamage + " points to " + k.getName() + " by Jawan Punch");
        k.healthDeplete(totalDamage);

        if (k.getHealth() <= 0) {
            System.out.println(getName() + " wins");
        }
    }
}