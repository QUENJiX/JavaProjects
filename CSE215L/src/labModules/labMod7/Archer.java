package labModules.labMod7;

// Archer extends RPGCharacter [cite: 350]
public class Archer extends RPGCharacter {
    private int accuracy; // [cite: 355]

    public Archer(String name, int level, int healthPoints, int accuracy) {
        super(name, level, healthPoints);
        this.accuracy = accuracy;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void shootEnemy() {
        System.out.println(getName() + " has shot an arrow to the enemy"); // [cite: 360]
    }

    public void increaseAccuracy() {
        // Increases accuracy by 10 plus current level multiplied by 2 [cite: 361]
        this.accuracy += 10 + (getLevel() * 2);
        System.out.println("Accuracy Increment is Successful " + getName()); // [cite: 362]
    }
}
