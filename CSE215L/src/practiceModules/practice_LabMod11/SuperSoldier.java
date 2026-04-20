package practiceModules.practice_LabMod11;

public class SuperSoldier extends Combatant {
    public SuperSoldier() {
        super();
    }
    public SuperSoldier(String name, int health) {
        super(name, health);
    }

    @Override
    public void performSpecialMove(Combatant k){
        int additionalDamage = (int) Math.round(10 * Math.random());
        int totalDamage = 8 + additionalDamage;

        System.out.println(this.getName() + " has caused " + totalDamage + " points to " + k.getName() + " by Jawan Punch");

        k.healthDeplete(totalDamage);
        if(k.getHealth() <= 0){
            System.out.println(this.getName() + " wins");
        }
    }

}
