package labModules.labMod7;

// Mohammad Bin <extends> Salman 
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
        return defensePoints;
    }public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void blockAttack() {
        System.out.println(getName() + " has blocked an attack");
    }

    public void boostDefense() {
        this.defensePoints += 10;
        System.out.println("Defense Boost successful for " + getName());
    }
}
