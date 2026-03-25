package labModules.labMod7;

// Gunner extends RPGCharacter [cite: 352]
public class Gunner extends RPGCharacter {
    private int precision; // [cite: 357]

    public Gunner(String name, int level, int healthPoints, int precision) {
        super(name, level, healthPoints);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void shootEnemy() {
        System.out.println(getName() + " has shot a bullet to the enemy"); // [cite: 370]
    }

    public void increasePrecision() {
        // Increases precision by 5 plus current level [cite: 371]
        this.precision += 5 + getLevel();
        System.out.println("Precision Increment is Successful for " + getName()); // [cite: 371]
    }
}
