package labModules.labMod7;

public class Warrior extends RPGCharacter {
    private int attackPoints;

    public Warrior(String name, int level, int healthPoints, int attackPoints) {
        super(name, level, healthPoints);
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void attackEnemy() {
        System.out.println(getName() + " has attacked an enemy");
    }

    public void parryAttack() {
        System.out.println(getName() + " has parried an attack");
    }

    public void boostAttack() {
        this.attackPoints += 10;
        System.out.println("Attack Point Increment is Successful " + getName());
    }
}
