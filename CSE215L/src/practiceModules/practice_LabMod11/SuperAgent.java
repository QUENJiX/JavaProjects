package practiceModules.practice_LabMod11;

public class SuperAgent extends Combatant {
    public SuperAgent() {
        super();
    }public SuperAgent(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k) {
        int additionalDamage = (int) Math.round(8 * Math.random());
        int totalDamage = 9 + additionalDamage;

        System.out.println(this.getName() + " has struck " + k.getName() + " with the Tiger Drive Shot and caused " + totalDamage + " points.");

        k.healthDeplete(totalDamage);
        if (k.getHealth() <= 0) {
            System.out.println(this.getName() + " wins");
        }
    }
}
