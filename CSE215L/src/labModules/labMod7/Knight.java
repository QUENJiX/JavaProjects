package labModules.labMod7;

// Sub-class named "Knight" that inherits the "RPGCharacter" class [cite: 342]
public class Knight extends RPGCharacter {
    // Additional data field [cite: 342]
    private int defensePoints;

    // Default constructor
    public Knight() {
        super();
        this.defensePoints = 0;
    }

    // Parameterized constructor
    public Knight(String name, int level, int healthPoints, int defensePoints) {
        super(name, level, healthPoints);
        this.defensePoints = defensePoints;
    }

    // Get and set methods for defensePoints [cite: 342]
    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    // blockAttack method [cite: 343]
    public void blockAttack() {
        System.out.println(getName() + " has blocked an attack"); // [cite: 343]
    }

    // boostDefense method [cite: 344]
    public void boostDefense() {
        this.defensePoints += 10; // [cite: 344]
        System.out.println("Defense Boost successful for " + getName()); // [cite: 344]
    }
}
