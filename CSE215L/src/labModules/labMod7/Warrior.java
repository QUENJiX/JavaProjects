package labModules.labMod7;

// Warrior extends RPGCharacter [cite: 353]
public class Warrior extends RPGCharacter {
    private int attackPoints; // [cite: 358]

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
        System.out.println(getName() + " has attacked an enemy"); // [cite: 372]
    }

    public void parryAttack() {
        System.out.println(getName() + " has parried an attack"); // [cite: 373]
    }

    public void boostAttack() {
        // Increase attack point by 10 [cite: 374]
        this.attackPoints += 10;
        System.out.println("Attack Point Increment is Successful " + getName()); // [cite: 374]
    }
}
