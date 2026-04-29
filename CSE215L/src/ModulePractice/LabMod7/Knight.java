package ModulePractice.LabMod7;

// Mohammad Bin Salman
public class Knight extends RPGCharacter {
    private int defensePoints;

    public Knight() {
        super();
        this.defensePoints = 0;
    }

    public Knight(String name, int level, int healthPoints, int defensePoints) {
        super(name, level, healthPoints);
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints() {
        return this.defensePoints;
    }
    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void blockAttack () {
        System.out.println(getName() + " has blocked an attack");
    }
    public void boostDefense() {
        this.defensePoints += 10;
        // x = x + 1
        // x += 1
        System.out.println("Defense boost successful for " + getName());
    }
}
